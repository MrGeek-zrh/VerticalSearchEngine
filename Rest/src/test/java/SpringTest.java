import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mrgeek.mapper.NewsMapper;
import com.mrgeek.pojo.News;
import com.mrgeek.pojo.NewsExample;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class SpringTest {

	@Autowired
	private NewsMapper newsMapper;

	@Test
	public void test1() throws Exception {
		NewsExample newsExample = new NewsExample();
		List<News> list = newsMapper.selectByExample(newsExample);
		System.out.println(list.size());
	}
}
