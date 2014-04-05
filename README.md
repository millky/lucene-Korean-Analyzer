lucene-Korean-Analyzer
======================

Lucene Analyzer For Korean

이수명님의 Analyzer ( http://cafe.naver.com/korlucene ) 를 형태소분석 Filter로 변형하여 사용하고 있으며 
직접 개발한 동의어 Filter, 복합명사 Filter등을 추가로 붙여 개발한 루씬용 한글 분석기 입니다.

루씬3.X, 루씬4.X 두가지 버전이 있으며, 3.X버전은 추가 업데이트는 없고 현재는
4.X 버전에 대해서만 업데이트를 진행하고 있습니다.

```
<!-- cd /java/github/lucene-Korean-Analyzer/korean-analyzer-4.x/target/libs/ -->
<!-- /java/maven/apache-maven-3.2.1/bin/mvn install:install-file -Dfile=korean-analyzer-4.x-0.7.5-SNAPSHOT.jar -DgroupId=com.tistory.devyongsik -DartifactId=korean-analyzer -Dversion=0.7.5-SNAPSHOT -Dpackaging=jar -->
	<dependency>
		<groupId>com.tistory.devyongsik</groupId>
		<artifactId>korean-analyzer</artifactId>
		<version>0.7.5-SNAPSHOT</version>
	</dependency>


	<dependency>
      <groupId>org.apache.lucene</groupId>
      <artifactId>lucene-core</artifactId>
      <version>4.6.0</version>
      <scope>compile</scope>
    </dependency>
    
        <dependency>
      <groupId>org.apache.lucene</groupId>
      <artifactId>lucene-analyzers-common</artifactId>
      <version>4.6.0</version>
      <scope>compile</scope>
    </dependency>

```