//package org.apache.lucene.analysis.ko.tagging;
//
//import java.util.List;
//
//import org.apache.lucene.analysis.TokenStream;
//import org.apache.lucene.analysis.ko.KoreanAnalyzer;
//import org.apache.lucene.analysis.ko.morph.AnalysisOutput;
//import org.apache.lucene.analysis.ko.morph.MorphException;
//import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
//import org.junit.Test;
//
//public class TaggerTest
//{
//	@Test
////	public void t()
////	{
////
////		Tagger tagger = new Tagger();
////		try
////		{
////			
//////			AnalysisOutput a = new AnalysisOutput();
//////			a.a
////			
////			AnalysisOutput ao = tagger.tagging("안녕하세요? 이슬기 입니다.", null);
////
////			if (ao != null)
////			{
////				List<String> ls = ao.getElist();
////				for (String string : ls)
////				{
////					System.out.println(string);
////				}
////			}
////			else
////			{
////				System.out.println("null");
////			}
////		}
////		catch (MorphException e)
////		{
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////	}
//	
//	
//	public void testKoreanAnalyzer() throws Exception
//	{
//
//		String input = "정식시호는 명헌숙경예인정목홍성장순정휘장소단희수현의헌강수유령자온공안효정왕후(明憲淑敬睿仁正穆弘聖章純貞徽莊昭端禧粹顯懿獻康綏裕寧慈溫恭安孝定王后)이며 돈령부영사(敦寧府領事) 홍재룡(洪在龍)의 딸이다. 1844년, 헌종의 정비(正妃)인 효현왕후가 승하하자 헌종의 계비로써 중궁에 책봉되었으나 5년 뒤인 1849년에 남편 헌종이 승하하고 철종이 즉위하자 19세의 어린 나이로 대비가 되었다. 1857년 시조모 대왕대비 순원왕후가 승하하자 왕대비가 되었다.";
//		input = "정식시호는 명헌숙경예인정목홍성장순정휘장소단희수현의헌강수유령자온공안효정왕후(明憲淑敬睿仁正穆弘聖章純貞徽莊昭端禧粹顯懿獻康綏裕寧慈溫恭安孝定王后)이며 돈령부영사(敦寧府領事) 홍재룡(洪在龍)의 딸이다.";
//		// input = "정식시호는 明憲淑敬睿";
//		// input =
//		// "정식시호는 명헌숙경예인정목홍성장순정휘장소단희수현의헌강수유령자온공안효정왕후(明憲淑敬睿仁正穆弘聖章純貞徽莊昭端禧粹顯懿獻康綏裕寧慈溫恭安孝定王后)이며 돈령부영사(敦寧府領事) 홍재룡(洪在龍)의 딸이다. 1844년, 헌종의 정비(正妃)인 효현왕후가 승하하자 헌종의 계비로써 중궁에 책봉되었으나 5년 뒤인 1849년에 남편 헌종이 승하하고 철종이 즉위하자 19세의 어린 나이로 대비가 되었다. 1857년 시조모 대왕대비 순원왕후가 승하하자 왕대비가 되었다. 정식시호는 明憲淑敬睿 '무궁화꽃이피었습니다.'와 같이 띄어 쓰기가 잘못된 오류를 교정하여 형태소 분석이 가능합니다. Standard[Index|Query]Tokenizer의 경우, 명사뿐 아니라 품사가 결합된 어절도 Token으로 뽑아냅니다.구글이 무선통신 사업을 준비하고 있다는 보도가 나오고 있다. 구글은 이미 칸자스 시티와 같은 몇몇 도시에 시범적으로 Google Fiber라는 초고속 인터넷 서비스를 하고 있는데, 이 지역들을 중심으로 버라이즌과 같은 다른 무선 통신 사업자에게 망을 빌려 쓰는 Mobile Virtual Network Operator (MVNO) 사업을 기획중이라는 것이다. 구글은 이미 스프린트와 접촉한 적이 있고, 최근에는 버라이즌과 협상을 벌이고 있다고 한다. 물론 기존 사업자들이 새로운 경쟁자가 될지 모르는 구글에 협조할지는 상당히 의문이다. MariaDB JDBC Client 1.1.7 includes several bug fixes and new features, e..g the support of LOAD DATA LOCAL INFILE. For a complete list please visit the Release notes page for MariaDB JDBC Client 1.1.7.";
//
//
//		KoreanAnalyzer a = new KoreanAnalyzer();
//		// StringBuilder actual = new StringBuilder();
//
//		TokenStream ts = a.tokenStream("bogus", input);
//		CharTermAttribute termAtt = ts.addAttribute(CharTermAttribute.class);
//		ts.reset();
//		while (ts.incrementToken())
//		{
//			System.out.println(termAtt.toString());
//			// actual.append(termAtt.toString());
//			// actual.append(',');
//		}
//		// System.out.println(actual);
//
//		// assertEquals("for line " + line + " input: " + input, expected, actual.toString());
//		ts.end();
//		ts.close();
//	}
//
//}
