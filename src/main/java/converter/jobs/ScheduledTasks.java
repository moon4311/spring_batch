package converter.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	
	
	@Autowired
	Sample1Configuration noticeConfiguration;
	
	@Autowired
	Sample2Configuration notice3DaysConfiguration;
	
	@Autowired
	private SimpleJobLauncher simpleJobLauncher;
	
	public void jobRun(Job job,String jobName){
		JobParametersBuilder jpb = new JobParametersBuilder();
		jpb.addString("JOB_NAME", jobName);
		jpb.addString("DATE", String.valueOf(System.currentTimeMillis()));
		JobParameters param = jpb.toJobParameters();
		simpleJobLauncher.setTaskExecutor( new SimpleAsyncTaskExecutor());
		try {
			simpleJobLauncher.run(job, param);
		} catch (JobExecutionAlreadyRunningException e) {
			e.printStackTrace();
		} catch (JobRestartException e) {
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Scheduled(fixedRate = 1000)  : 현재실행 후  fixedRate(밀리초) 마다 실행
	 * @Scheduled(cron ="0 0 * * * ?")  : * 월 * 일 * 시 0분 0초 마다 실행
	 */
	@Scheduled(fixedRate = 60000)	//60초 마다
	public void noticeConfRun(){
		jobRun(Sample1Configuration.job(),new Object(){}.getClass().getEnclosingMethod().getName() );
		
	}

//	@Scheduled(cron = "0 0 * * * ?") // 매시간 마다
	@Scheduled(cron = "0 0 8,12,18 * * ?") // 매일 8시,12시,18시
	public void sampleConfRun(){
		jobRun(Sample2Configuration.job(), new Object(){}.getClass().getEnclosingMethod().getName());
		
	}
	
	
}
