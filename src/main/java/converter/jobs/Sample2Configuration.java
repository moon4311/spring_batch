package converter.jobs;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
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
import converter.jobs.listener.SampleJobListener;
import converter.jobs.processor.SampleItemProcessor;
import converter.jobs.writer.NewItemWriter;
import converter.jobs.writer.ModifyItemWriter;

@Configuration
@EnableBatchProcessing
public class Sample2Configuration {

	private static final int MaxCount = 1000;
	
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
                .next(step2())
                .listener(sampleJobListener())
                .build();
    }
    
    @Bean("step1")	//신규
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Sample, Sample>chunk(MaxCount)
                .reader(getItemReader("converter.comn.mapper106.Sample106Dao.selectSampleBase"))
                .writer(newItemWriter())
                .build();
    }

   @Bean("step2")	//수정
    public Step step2() {
    	return stepBuilderFactory.get("step2")
    			.<Sample, Sample>chunk(MaxCount)
    			.reader(getItemReader("converter.comn.mapper106.Sample106Dao.selectSampleBaseToUpdate"))
    			.processor(sampleItemProcessor())
    			.writer(modifyItemWriter())
    			.build();
    }

    private MyBatisCursorItemReader<Sample> getItemReader(String queryId){
    	MyBatisCursorItemReader<Sample> itemReader = new MyBatisCursorItemReader<Sample>();
        itemReader.setSqlSessionFactory(db2SqlSessionFactory);
        Map<String,Object> params = new HashMap<String, Object>();
        itemReader.setParameterValues(params);
        itemReader.setQueryId(queryId);
        return itemReader;
    }
    
	@Bean("newItemProcessor")
	public ItemProcessor<Sample, Sample> sampleItemProcessor() {
		return  new SampleItemProcessor();
	}

	@Bean("newItemWriter")
	public ItemWriter<Sample> newItemWriter() {
		return new NewItemWriter();
	}
    
	@Bean("modifyItemWriter")
	public ItemWriter<Sample> modifyItemWriter() {
		return new ModifyItemWriter();
	}
	
	@Bean("sampleJobListener")
	public JobExecutionListener sampleJobListener(){
		return new SampleJobListener();
	}
    
}