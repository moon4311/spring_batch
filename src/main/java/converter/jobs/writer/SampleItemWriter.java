package converter.jobs.writer;

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

import converter.comn.vo.Sample;

/**
 * 개찰 공고수집 ItemWriter
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
public class SampleItemWriter implements ItemWriter<Sample>, ItemWriteListener<Sample> {

	Long startTime;
	
	/*		테스트 DB		*/
	@Resource(name="db1SqlSessionFactory")
	private SqlSessionFactory db1SqlSessionFactory;

	/*		테스트 DB		*/
	@Resource(name="db2SqlSessionFactory")
	private SqlSessionFactory db2SqlSessionFactory;
	
	
	
	
	@Override
	public void beforeWrite(List<? extends Sample> items) {
		// 시작 시간
				startTime = System.currentTimeMillis();
				System.out.print(" SampleWriter[start] size : " + items.size() +"개 / ");
	}
	
    @Override
    public void write(List<? extends Sample> SampleList) throws Exception {
    	MyBatisBatchItemWriter<Sample> itemWriter = new MyBatisBatchItemWriter<>() ;
		itemWriter.setSqlSessionFactory(db1SqlSessionFactory);
		itemWriter.setStatementId("insertSample");
		itemWriter.setAssertUpdates(false);
    	itemWriter.write(SampleList);
    	
    	for(Sample Sample : SampleList){
    		
    		Map<String,Object> map = new HashMap<String,Object>();
    		map.put("id", Sample.getId());
    		
    		List<SampleAtchmnfl> licnsList = db2SqlSessionFactory.openSession().selectList("selectSampleLicense",map);

    		insertMap("insertSampleLicns",licnsList);
    		
    	}
    	
    }
    
	@Override
	public void afterWrite(List<? extends Sample> items) {
		System.out.println("afterWrite:  " + (System.currentTimeMillis() - startTime) / 1000.0f + "초 / ");
	}


	@Override
	public void onWriteError(Exception exception, List<? extends Sample> items) {
		System.out.println("SampleItemListener : " + exception.getMessage());
		
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
