package shekhar.hr.algorithm

import org.apache.spark._
import org.apache.spark.mllib.feature.{Word2Vec, Word2VecModel}

/**
  * Created by sagraw200 on 23/04/16.
  */
// spark-submit : ./spark-submit --class shekhar.hr.algorithm.W2V --master local[4] --driver-memory 1G --executor-memory 2G /Users/sagraw200/Documents/dev/team-personal/gandalf/target/scala-2.10/headhunt_2.10-1.0.jar
object W2V {

  object props {
    val jdfile : String = "/Users/sagraw200/Documents/dev/team-personal/gandalf/src/main/resources/data/ingest/linkedin.jd.tmp.2"
    val w2vmodel : String = "/Users/sagraw200/Documents/dev/team-personal/gandalf/src/main/resources/data/ingest/w2v"
    val keys = List("java", "c++", "big data")
    val N = 10
  }

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("wordtovec").setMaster("spark://" + "localhost" + ":7077")
    val sc = new SparkContext(conf)
//    sc.setCheckpointDir("/Users/sagraw200/Documents/dev/team-personal/gandalf/debug_checkpoint/")

    trainWordTovec(sc, props.jdfile, props.w2vmodel)
    val model : Word2VecModel = loadWordToVec(sc, props.w2vmodel)

    // test model
    getRelatedKeys(model, props.keys, props.N)
  }

  def trainWordTovec(sc : SparkContext, inp: String, out: String): Unit = {
    val data = sc.textFile(inp).map(line => line.split(" ").toSeq)
    val word2vec = new Word2Vec()
    val model = word2vec.fit(data)
    model.save(sc, out)
  }

  def loadWordToVec(sc : SparkContext, modelfile : String): Word2VecModel = {
    val model : Word2VecModel = Word2VecModel.load(sc, modelfile)
    model
  }

  def getRelatedKeys(model: Word2VecModel, keys: List[String], N : Int): Unit = {
    for (key <- keys) {
        val synonyms = model.findSynonyms(key, N)
        for ((synonym, cosineSimilarity) <- synonyms) {
          println(s"$synonym $cosineSimilarity")
        }
      }
    }

}
