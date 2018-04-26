package jinbid.converter.jobs.noti.writer;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import jinbid.converter.comn.vo.Notice;
import jinbid.converter.comn.vo.NoticeAtchmnfl;
import jinbid.converter.comn.vo.NoticeOrign;

/**
 * 개찰 공고수집 ItemWriter
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
public class NoticeItemWriter implements ItemWriter<Notice>, ItemWriteListener<Notice> {

	Long startTime;
	
	/*		테스트 DB		*/
	@Resource(name="db1SqlSessionFactory")
	private SqlSessionFactory db1SqlSessionFactory;

	/*		테스트 DB		*/
	@Resource(name="db2SqlSessionFactory")
	private SqlSessionFactory db2SqlSessionFactory;
	
	
	
	
	@Override
	public void beforeWrite(List<? extends Notice> items) {
		// 시작 시간
				startTime = System.currentTimeMillis();
				System.out.print(" noticeWriter[start] size : " + items.size() +"개 / ");
	}
	
    @Override
    public void write(List<? extends Notice> noticeList) throws Exception {
    	MyBatisBatchItemWriter<Notice> itemWriter = new MyBatisBatchItemWriter<>() ;
		itemWriter.setSqlSessionFactory(db1SqlSessionFactory);
		itemWriter.setStatementId("insertNotice");
		itemWriter.setAssertUpdates(false);
    	itemWriter.write(noticeList);
    	
    	for(Notice notice : noticeList){
    		
    		Map<String,Object> map = new HashMap<String,Object>();
    		map.put("id", notice.getId());
    		map.put("prfId", notice.getPrfId());
    		map.put("baseAmt", notice.getBaseAmt());
    		
    		
    		List<NoticeAtchmnfl> licnsList = db2SqlSessionFactory.openSession().selectList("selectNoticeLicense",map);
    		List<NoticeAtchmnfl> atchList = db2SqlSessionFactory.openSession().selectList("selectNoticeAtchmnfl",map);
    		List<NoticeAtchmnfl> areaList = db2SqlSessionFactory.openSession().selectList("selectNoticeArea",map);
    		List<NoticeAtchmnfl> compList = db2SqlSessionFactory.openSession().selectList("selectNoticeCompnoPrdprcList",map);
    		List<NoticeAtchmnfl> bdprList = db2SqlSessionFactory.openSession().selectList("selectNoticeBdprPrtcCmp",map);
    		List<NoticeAtchmnfl> sbidList = db2SqlSessionFactory.openSession().selectList("selectNoticeSbidPrargCmp",map);
    		List<NoticeOrign> orignList = db2SqlSessionFactory.openSession().selectList("selectNoticeOrign",map);

    		insertMap("insertNoticeLicns",licnsList);
    		insertMap("insertNoticeArea",areaList);
    		insertMap("insertCompnoPrdprc",compList);
    		insertMap("insertNoticeBddprPrtcCmp",bdprList);
    		insertMap("insertNoticeSbidPrargCmp",sbidList);
    		insertMap("insertNoticeAtchmnfl",atchList);
    		insertMap("insertNoticeOrign",orignList);
    		
    	}
    	
    }
    
	@Override
	public void afterWrite(List<? extends Notice> items) {
		System.out.println("afterWrite:  " + (System.currentTimeMillis() - startTime) / 1000.0f + "초 / ");
	}


	@Override
	public void onWriteError(Exception exception, List<? extends Notice> items) {
		System.out.println("NoticeItemListener : " + exception.getMessage());
		
	}
	
	
	public void insertMap(String query, List list){
		if(list.size()>0){
			Map map = new HashMap();
    		map.put("list", list);
    		db1SqlSessionFactory.openSession().insert(query,map);
		}
		
	}
	
	
	
	public String formatTime(long lTime) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(lTime);
		return (c.get(Calendar.HOUR_OF_DAY) + "시 " + c.get(Calendar.MINUTE) + "분 " + c.get(Calendar.SECOND) + "."
				+ c.get(Calendar.MILLISECOND) + "초");
	} // end function formatTime()
	
	
	
}
