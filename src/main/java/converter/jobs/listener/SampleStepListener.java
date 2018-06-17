package converter.jobs.listener;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class SampleStepListener implements StepExecutionListener{

    @Resource(name="db1SqlSessionFactory")
    private SqlSessionFactory db1SqlSessionFactory;
	
    
    @Override
    public void beforeStep(StepExecution stepExecution) {
		System.out.println("***** stepStart  : " + stepExecution.getStartTime());
    }
    
    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
    	
    	int readCnt = stepExecution.getReadCount();
    	int writeCnt = stepExecution.getWriteCount();
    	SqlSession session = db1SqlSessionFactory.openSession();
    	session.update("updatexxxxx");
    	
    	return null;
    }
    
}
