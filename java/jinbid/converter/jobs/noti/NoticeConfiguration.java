package jinbid.converter.jobs.noti;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import jinbid.converter.comn.vo.Notice;
import jinbid.converter.jobs.noti.listener.NoticeStepListener;
import jinbid.converter.jobs.noti.processor.NoticeItemProcessor;
import jinbid.converter.jobs.noti.writer.NoticeItemWriter;


@Configuration
@EnableBatchProcessing
public class NoticeConfiguration {

	private final static int MaxCount = 300;
	private final static String START_DATE = "2016-08-01 00:00:00";
	private final static String END_DATE 	  = "2016-08-30 00:00:00";
	
	
	@Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    
    @Resource(name="db1SqlSessionFactory")
    private SqlSessionFactory db1SqlSessionFactory;
    
    @Resource(name="db2SqlSessionFactory")
    private SqlSessionFactory db2SqlSessionFactory;
    
    
    @Bean("testJob")
    public Job job() {
        return  jobBuilderFactory.get("testJob")
                .incrementer(new RunIdIncrementer())
                .start(step1())
                .build();
    }
   
    /**
     * 1. 구 NoticeBase MaxCount만큼 조회   	itemReader -  selectNoticeBase
     * 2. 신 NOTI 존재 항목 삭제 noticeItemProcessor
     * 3. 신 NOTI 입력					noticeItemWriter- insertNotice
     * 4. 신 NOTI_AREA / NOTI_COMPNO... / NOTI_ATCH... / NOTI_SBID ... / NOTI_BDPR... / NOTI_LICNS / NOTI_ORIGN 입력
     * 5. 1~ 4 반복
     * 6. 신 NOTI (발주처코드/실수요기관코드/적격심사기준ID ) 컬럼들 업데이트	noticeStepListener
     * @return
     */
    @Bean("step1")	//신규
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Notice, Notice>chunk(MaxCount)
                .reader(getItemReader("jinbid.converter.comn.mapper106.Notice106Dao.selectNoticeBase"))
                .processor(noticeItemProcessor())
                .writer(noticeItemWriter())
                .listener(noticeStepListener())
                .build();
    }

    private MyBatisPagingItemReader<Notice> getItemReader(String queryId){
    	MyBatisPagingItemReader<Notice> itemReader = new MyBatisPagingItemReader<Notice>();
        itemReader.setSqlSessionFactory(db2SqlSessionFactory);
        Map<String,Object> params = new HashMap<String, Object>();
        
        params.put("startDate", START_DATE);
        params.put("endDate", END_DATE);
        try {
        	itemReader.setParameterValues(params);
        	itemReader.setQueryId(queryId);
			itemReader.afterPropertiesSet();
			itemReader.setPageSize(MaxCount);	//리스트크기
		} catch (Exception e) {
			e.printStackTrace();
		}
        return itemReader;
    }

	@Bean("noticeItemProcessor")
	public ItemProcessor<Notice, Notice> noticeItemProcessor() {
		return  new NoticeItemProcessor();
	}

	@Bean("noticeItemWriter")
	public ItemWriter<Notice> noticeItemWriter() {
		return new NoticeItemWriter();
	}

	@Bean("noticeStepListener")
	public StepExecutionListener noticeStepListener(){
		return new NoticeStepListener();
	}
	
	//다중 writer 쓸 때
	/*public CompositeItemWriter<?> compositeItemWriter(){
	    CompositeItemWriter writer = new CompositeItemWriter();
	    writer.setDelegates(Arrays.asList(new NoticeItemWriter(),new CodeUpdateItemWriter()));
	    return writer;
	}*/
	
}