package converter.jobs;


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

import converter.comn.vo.Sample;
import converter.jobs.listener.SampleStepListener;
import converter.jobs.processor.SampleItemProcessor;
import converter.jobs.writer.SampleItemWriter;

@Configuration
@EnableBatchProcessing
public class Sample1Configuration {

	int MaxCount =1000;
	
	
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
//                .next(step2())
                .build();
    }
   
    @Bean("step1")	//신규
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Sample, Sample>chunk(MaxCount)
                .reader(getPagingItemReader("converter.comn.mapper106.sample106Dao.selectsampleBase"))
                .processor(sampleItemProcessor())
                .writer(sampleItemWriter())
                .listener(sampleStepListener())
                .build();
    }

    private MyBatisPagingItemReader<Sample> getPagingItemReader(String queryId){
    	MyBatisPagingItemReader<Sample> itemReader = new MyBatisPagingItemReader<Sample>();
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
	public ItemProcessor<Sample, Sample> sampleItemProcessor() {
		return  new SampleItemProcessor();
	}

	@Bean("sampleItemWriter")
	public ItemWriter<Sample> sampleItemWriter() {
		return new SampleItemWriter();
	}

	@Bean("sampleStepListener")
	public StepExecutionListener sampleStepListener(){
		return new SampleStepListener();
	}
	
	//다중 writer 쓸 때
	/*public CompositeItemWriter<?> compositeItemWriter(){
	    CompositeItemWriter writer = new CompositeItemWriter();
	    writer.setDelegates(Arrays.asList(new sampleItemWriter(),new CodeUpdateItemWriter()));
	    return writer;
	}*/
	
}
