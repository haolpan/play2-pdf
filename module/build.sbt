name := "play2-pdf"

organization := "it.innove"

version := "1.11.0"

lazy val root = (project in file(".")).enablePlugins(PlayMinimalJava)

scalaVersion := "2.13.10"

crossPaths := false

libraryDependencies ++= Seq(
  "commons-io" % "commons-io" % "2.16.1",
  "org.xhtmlrenderer" % "flying-saucer-pdf" % "9.2.0",
  "nu.validator.htmlparser" % "htmlparser" % "1.4"
)

resolvers ++= Seq(
  "Maven Central" at "https://repo1.maven.org/maven2/"
)

publishMavenStyle := true

Test / publishArtifact := false

pomIncludeRepository := { _ => false }

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := (
  <url>https://github.com/innoveit/play2-pdf</url>
  <licenses>
    <license>
      <name>MIT license</name>
      <url>https://www.opensource.org/licenses/mit-license.php</url>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:innoveit/play2-pdf.git</url>
    <connection>scm:git:git@github.com:innoveit/play2-pdf.git</connection>
  </scm>
  <developers>
	<developer>
		<id>marcosinigaglia</id>
        <name>Marco Sinigaglia</name>
        <url>https://www.innove.it</url>
    </developer>
  </developers>
)

credentials += Credentials(Path.userHome / ".ivy2/sonatype.prop")
