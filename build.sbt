name := "headhunt"
version := "1.0"
scalaVersion := "2.10.6"

libraryDependencies ++= Seq(

  // spark
  "org.apache.spark" % "spark-core_2.10" % "1.6.0",
  "org.apache.spark" % "spark-mllib_2.10" % "1.6.0" ,
  "org.apache.spark" % "spark-streaming_2.10" % "1.6.0" ,
  "org.apache.spark" % "spark-hive_2.10" % "1.6.0" ,
  "org.apache.spark" % "spark-sql_2.10" % "1.6.0" ,

  "org.spark-project.hive" % "hive-metastore" % "1.2.1.spark" ,

  // json
  "com.fasterxml.jackson.core" % "jackson-core" % "2.5.1" ,
  "org.json4s" % "json4s-jackson_2.10" % "3.2.10" ,
  "org.json4s" % "json4s-native_2.10" % "3.2.10" ,
  "org.json4s" % "json4s-ast_2.10" % "3.2.10" ,
  "org.json" % "json" % "20160212",
  "com.google.code.gson" % "gson" % "2.6",

  "com.google.guava" % "guava" % "18.0" ,


  //MEMSQL
  "com.memsql" % "memsql-connector_2.10" % "1.2.1" ,
  "mysql" % "mysql-connector-java" % "5.1.38" ,
  "com.memsql" %% "memsql-etl" % "1.2.1" ,

  //KAFKA
  "com.datastax.spark" % "kafka-streaming_2.10" % "1.1.2" ,
  "org.apache.kafka" % "kafka_2.10" % "0.8.2.2" ,
  "org.apache.kafka" % "kafka-clients" % "0.8.2.2" ,
  "org.apache.spark" % "spark-streaming-kafka_2.10" % "1.6.0"  ,
  "org.apache.spark" % "spark-streaming-twitter_2.10" % "1.5.2",

  "com.owlike" % "genson" % "1.4",
  "com.sun.jersey" % "jersey-servlet" % "1.19",
  // HTML
  "org.jsoup" % "jsoup" % "1.9.1"


  // SBT PLUGIN
  //,"com.eed3si9n" % "sbt-assembly_2.8.1" % "sbt0.10.0_0.6"

)

unmanagedBase <<= baseDirectory { base => base / "lib" }
