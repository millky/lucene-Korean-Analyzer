//package com.tistory.devyongsik.analyzer;
//
//
//
//import java.io.IOException;
//import java.io.StringReader;
//import java.util.HashSet;
//import java.util.Set;
//
//import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
//import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.tistory.devyongsik.analyzer.util.AnalyzerTestUtil;
//import com.tistory.devyongsik.analyzer.util.TestToken;
//
///**
// *
// * @author 장용석, 2011.07.16 need4spd@naver.com
// */
//
//public class KoreanCharacterTokenizerTest extends AnalyzerTestUtil {
//	
//	private Set<TestToken> tokenizedToken = new HashSet<TestToken>();
//	private StringReader content = new StringReader("삼성전자absc1234엠피3mp3버전1.2  띄어쓰기");
//	private KoreanCharacterTokenizer tokenizer = new KoreanCharacterTokenizer(content);
//
//	@Before
//	public void setUp() throws IOException {
//		tokenizedToken.add(getToken("띄어쓰기", 25, 29));
//		tokenizedToken.add(getToken("2", 22, 23));
//		tokenizedToken.add(getToken("1", 20, 21));
//		tokenizedToken.add(getToken("버전", 18, 20));
//		tokenizedToken.add(getToken("3",17, 18));
//		tokenizedToken.add(getToken("mp", 15, 17));
//		tokenizedToken.add(getToken("3", 14, 15));
//		tokenizedToken.add(getToken("엠피", 12, 14));
//		tokenizedToken.add(getToken("1234", 8, 12));
//		tokenizedToken.add(getToken("absc", 4, 8));
//		tokenizedToken.add(getToken("삼성전자", 0, 4));
//		
//		tokenizer.reset();
//	}
//
//	@Test
//	public void testIncrementToken() throws IOException {
//		CharTermAttribute charTermAtt = tokenizer.getAttribute(CharTermAttribute.class);
//		OffsetAttribute offSetAtt = tokenizer.getAttribute(OffsetAttribute.class);
//		
//		while(tokenizer.incrementToken()) {
//			TestToken t = getToken(charTermAtt.toString(), offSetAtt.startOffset(), offSetAtt.endOffset());
//			System.out.println("termAtt.term() : " + charTermAtt.toString());
//			System.out.println("offSetAtt : " + offSetAtt.startOffset());
//			System.out.println("offSetAtt : " + offSetAtt.endOffset());
//
//			Assert.assertTrue(tokenizedToken.contains(t));
//		}
//	}
//}


package com.tistory.devyongsik.analyzer;


import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.apache.lucene.analysis.ko.morph.AnalysisOutput;
import org.apache.lucene.analysis.ko.morph.CompoundEntry;
import org.apache.lucene.analysis.ko.morph.MorphAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.Test;

import com.tistory.devyongsik.analyzer.util.AnalyzerTestUtil;

/**
 *
 * @author 장용석, 2011.07.16 need4spd@naver.com
 */

public class KoreanCharacterTokenizerTest extends AnalyzerTestUtil
{


	String
	// input =
	// "정식시호는 명헌숙경예인정목홍성장순정휘장소단희수현의헌강수유령자온공안효정왕후(明憲淑敬睿仁正穆弘聖章純貞徽莊昭端禧粹顯懿獻康綏裕寧慈溫恭安孝定王后)이며 돈령부영사(敦寧府領事) 홍재룡(洪在龍)의 딸이다. 1844년, 헌종의 정비(正妃)인 효현왕후가 승하하자 헌종의 계비로써 중궁에 책봉되었으나 5년 뒤인 1849년에 남편 헌종이 승하하고 철종이 즉위하자 19세의 어린 나이로 대비가 되었다. 1857년 시조모 대왕대비 순원왕후가 승하하자 왕대비가 되었다.";
	input = "'무궁화꽃이피었습니다.'와 같이 띄어 쓰기가 잘못된 오류를 교정하여 형태소 분석이 형태소 분석이 형태소 분석이  가능합니다. Standard[Index|Query]Tokenizer의 경우, 명사뿐 아니라 품사가 결합된 어절도 Token으로 뽑아냅니다.구글이 무선통신 사업을 준비하고 있다는 보도가 나오고 있다. 구글은 이미 칸자스 시티와 같은 몇몇 도시에 시범적으로 Google Fiber라는 초고속 인터넷 서비스를 하고 있는데, 이 지역들을 중심으로 버라이즌과 같은 다른 무선 통신 사업자에게 망을 빌려 쓰는 Mobile Virtual Network Operator (MVNO) 사업을 기획중이라는 것이다. 구글은 이미 스프린트와 접촉한 적이 있고, 최근에는 버라이즌과 협상을 벌이고 있다고 한다. 물론 기존 사업자들이 새로운 경쟁자가 될지 모르는 구글에 협조할지는 상당히 의문이다. MariaDB JDBC Client 1.1.7 includes several bug fixes and new features, e..g the support of LOAD DATA LOCAL INFILE. For a complete list please visit the Release notes page for MariaDB JDBC Client 1.1.7. starMaria, under, visit, Library, 7, 2, 1, 0, MariaDB, proud, cache, which, Notes, fully, released, Client, Thank, JDBC, more!, LOCAL, MySQL, and, major, fixes, MinGW, ports, for, notes, C, Maven, ,";

	// input =
	// "개발자 이신가요? 최신정보, 관심있어 하실만한 컨텐츠들을 모아서 보여드려요! 좋은 글은 등록해주셔도 되구요~ 추천도 가능합니다.그리고 좋은 책도 추천 받을께요 ^^ 서평도 부탁드립니다!! The Korean Analysis plugin integrates Lucene Korean analysis module into elasticsearch. 가돌리늄착화합물새로운 버전이 업데이트 되었군요! 축하드립니다.혹시 개발하실때 이클립스 쓰시나요? 이클립스 버전에 따라 실행이 되기도 않되기도 해서요.(갈릴레오버전에서는 실행이 안되며, 주노버전에서는 잘되네요. - 이클립스문제일테지만.. 한참을 헤맸네요.ㅎ)프로젝트 덩치가 점점커지니 기분이 좋으시겠습니다!!ㅎ";


	// private Set<TestToken> tokenizedToken = new HashSet<TestToken>();
	// private StringReader content = new StringReader(input);
	// private KoreanCharacterTokenizer tokenizer = new KoreanCharacterTokenizer(content);

	// @Before
	// public void setUp() throws IOException {
	// tokenizedToken.add(getToken("띄어쓰기", 25, 29));
	// tokenizedToken.add(getToken("2", 22, 23));
	// tokenizedToken.add(getToken("1", 20, 21));
	// tokenizedToken.add(getToken("버전", 18, 20));
	// tokenizedToken.add(getToken("3",17, 18));
	// tokenizedToken.add(getToken("mp", 15, 17));
	// tokenizedToken.add(getToken("3", 14, 15));
	// tokenizedToken.add(getToken("엠피", 12, 14));
	// tokenizedToken.add(getToken("1234", 8, 12));
	// tokenizedToken.add(getToken("absc", 4, 8));
	// tokenizedToken.add(getToken("삼성전자", 0, 4));
	//
	// tokenizer.reset();
	// }

	@Test
	public void testIncrementToken() throws IOException, Exception
	{
		StringReader content = new StringReader(input);
		KoreanCharacterTokenizer tokenizer = new KoreanCharacterTokenizer(content);
		// TokenStream stream = new KoreanNounFilter(new KoreanCharacterTokenizer(reader), engines);
		//

		tokenizer.reset();
		CharTermAttribute charTermAtt = tokenizer.getAttribute(CharTermAttribute.class);
		// OffsetAttribute offSetAtt = tokenizer.getAttribute(OffsetAttribute.class);

		StringBuilder actual = new StringBuilder();

		while (tokenizer.incrementToken())
		{
			// TestToken t = getToken(charTermAtt.toString(), offSetAtt.startOffset(), offSetAtt.endOffset());
			System.out.println("termAtt.term() : " + charTermAtt.toString());
			// System.out.println("offSetAtt : " + offSetAtt.startOffset());
			// System.out.println("offSetAtt : " + offSetAtt.endOffset());

			// Assert.assertTrue(tokenizedToken.contains(t));

			actual.append(charTermAtt.toString());
			actual.append(' ');
		}
		tokenizer.close();

		String[] terms = actual.toString().split(" ");

		// String[] terms = new String[] {
		// // "아름다운", "푸미폰국왕은", "정교로운","냉방을",
		// // "하고",
		// // "전기를",
		// // "만들고","공장을","가동하는",
		// "진산세고" };

		long start = System.currentTimeMillis();

		int i = 0;


		MorphAnalyzer morphAnalyzer = new MorphAnalyzer();
		for (String term : terms)
		{

			List<AnalysisOutput> results = morphAnalyzer.analyze(term);
			// results.addAll(morphAnalyzer.analyze(term));

			for (AnalysisOutput o : results)
			{
				if (o.getStem().length() > 1)
				// if (o.getPatn() == 1 && o.getScore() > 50 && o.getStem().length() > 1)
				{
					System.out.print(i + " (((" + o.getStem().length() + ":o.getStem().length()");

					List<CompoundEntry> entries = o.getCNounList();
					for (CompoundEntry entry : entries)
					{
						// System.out.print(entry.getWord() + "/");
						System.out.print(entry.getWord());
					}

					if (entries.size() == 0)
						System.out.print(o.getStem());
					System.out.print("<" + o.getPatn() + ">->" + o.getScore() + ":" + o.getPos());

					// System.out.println("["+o.getSource()+"]");
					// System.out.println("[" + o.getSource() + "]");
					System.out.println(")))");
					i++;

					// System.out.println("o.getEomi() : " + o.getEomi());
					// System.out.println("o.getPomi() : " + o.getPomi());
					// List<String> ls = o.getElist();
					// for (String string : ls)
					// {
					// System.out.println("le : " + string);
					// }
					// List<String> lj = o.getJlist();
					// for (String string : lj)
					// {
					// System.out.println("lj : " + string);
					// }

				}
			}
			// System.out.println(term.toString());
		}

		System.out.println((System.currentTimeMillis() - start) + "ms : " + i);

	}
}
