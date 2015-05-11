name := "db"

version := "1.0"

scalaVersion := "2.11.6"

//http://claude.betancourt.us/add-microsoft-sql-jdbc-driver-to-maven/
libraryDependencies ++= Seq(
  "com.h2database"  %  "h2"                % "1.4.187",
  "net.sourceforge.jtds" % "jtds" % "1.2.4",

  "org.scalikejdbc" %% "scalikejdbc"       % "2.2.6",
  "ch.qos.logback"  %  "logback-classic"   % "1.1.3",


  "org.squeryl" %% "squeryl" % "0.9.5-7",
  "c3p0" % "c3p0" % "0.9.1.2"
)
    