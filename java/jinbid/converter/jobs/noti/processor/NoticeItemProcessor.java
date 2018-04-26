package jinbid.converter.jobs.noti.processor;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.item.ItemProcessor;

import jinbid.converter.comn.vo.Notice;

/**
 * 개찰 공고수집 ItemWriter
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
public class NoticeItemProcessor implements ItemProcessor<Notice, Notice> {

    @Resource(name="db1SqlSessionFactory")
    private SqlSessionFactory db1SqlSessionFactory;
	
	@Override
	public Notice process(Notice notice) throws Exception{
//		System.out.println(notice);
		Map<String,Object> params = new HashMap();
		params.put("prfId", notice.getPrfId());
		Notice tmp = db1SqlSessionFactory.openSession().selectOne("selectExistedNotice", params);
		if(tmp != null){ 
			return null;
		}
		return notice;
	}
	
}