package jinbid.converter.jobs.noti.listener;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.ItemWriteListener;

import jinbid.converter.comn.vo.Notice;

public class NoticeItemWriterListener implements ItemWriteListener<Notice>{
	
	/*		테스트 DB		*/
	@Resource(name="db1SqlSessionFactory")
	private SqlSessionFactory db1SqlSessionFactory;
	
	@Override
	public void afterWrite(List<? extends Notice> items) {
    	SqlSession session = db1SqlSessionFactory.openSession();
    	session.update("updateNewestNotiYn");	/***  변경   * */
    	session.commit();
    	session.close();	
	}
	@Override
	public void beforeWrite(List<? extends Notice> items) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onWriteError(Exception exception, List<? extends Notice> items) {
		// TODO Auto-generated method stub
		
	}

}
