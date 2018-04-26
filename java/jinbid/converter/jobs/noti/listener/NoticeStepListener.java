package jinbid.converter.jobs.noti.listener;

import java.util.Calendar;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class NoticeStepListener implements StepExecutionListener{

	Long startTime,endTime;
	
    @Resource(name="db1SqlSessionFactory")
    private SqlSessionFactory db1SqlSessionFactory;
	
    
    @Override
    public void beforeStep(StepExecution stepExecution) {
    	startTime = System.currentTimeMillis();
		System.out.println("***** stepStart  : " + stepExecution.getStartTime());
    }
    
    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
    	
    	int readCnt = stepExecution.getReadCount();
    	int writeCnt = stepExecution.getWriteCount();
    	endTime = System.currentTimeMillis();
    	SqlSession session = db1SqlSessionFactory.openSession();
    	System.out.println("***** stepEnd : "+formatTime(endTime) + "  /  " + (endTime - startTime) / 1000.0f + "초 / read " + readCnt + " 건 / write " +writeCnt+" 건" );
    	session.update("updateOrderOffiCd");	/*** 공고 발주처코드 변경   **/    
    	session.update("updateActulDnttCd");	/*** 공고 실수요기관코드 변경   **/
    	session.update("updateCfmtUndwrtStId");	/*** 적격심사기준ID 변경   * */
    	
    	return null;
    }
    
	public String formatTime(long lTime) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(lTime);
		return (c.get(Calendar.HOUR_OF_DAY) + "시 " + c.get(Calendar.MINUTE) + "분 " + c.get(Calendar.SECOND) + "."
				+ c.get(Calendar.MILLISECOND) + "초");
	} // end function formatTime()
	
}
