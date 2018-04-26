package converter.jobs.noti;


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


import converter.comn.vo.sample;
import converter.jobs.listener.SampleStepListener;
import converter.jobs.processor.SampleItemProcessor;
import converter.jobs.writer.SampleItemWriter;


@Configuration
@EnableBatchProcessing
public class SampleConfiguration {

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
   
    @Bean("step1")	//신규
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<sample, sample>chunk(MaxCount)
                .reader(getPagingItemReader("converter.comn.mapper106.sample106Dao.selectsampleBase"))
                .processor(sampleItemProcessor())
                .writer(sampleItemWriter())
                .listener(sampleStepListener())
                .build();
    }

    private MyBatisPagingItemReader<sample> getPagingItemReader(String queryId){
    	MyBatisPagingItemReader<sample> itemReader = new MyBatisPagingItemReader<sample>();
        itemReader.setSqlSessionFactory(db2SqlSessionFactory);
        Map<String,Object> params = new HashMap<String, Object>();
        
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

	@Bean("sampleItemProcessor")
	public ItemProcessor<sample, sample> sampleItemProcessor() {
		return  new sampleItemProcessor();
	}

	@Bean("sampleItemWriter")
	public ItemWriter<sample> sampleItemWriter() {
		return new sampleItemWriter();
	}

	@Bean("sampleStepListener")
	public StepExecutionListener sampleStepListener(){
		return new sampleStepListener();
	}
	
	//다중 writer 쓸 때
	/*public CompositeItemWriter<?> compositeItemWriter(){
	    CompositeItemWriter writer = new CompositeItemWriter();
	    writer.setDelegates(Arrays.asList(new sampleItemWriter(),new CodeUpdateItemWriter()));
	    return writer;
	}*/
	
}