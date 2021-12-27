# spring_batch
spring_batch [spring boot + mybatis + mysql]


Flow 1
ConverterApplication > Sample1Configuration
	  job > step > itemReader > itemProcessor >  itemWriter
	
		
	jobBuilder add  .listener( new CustomJobExecutionListener () ) # before added @bean
	 @Override beforeJob / afterJob
	 
	stepBuilder add .listener( new CustomStepExecutionListener () ) # before added @bean
	 @Override	beforeStep / afterStep
	
	stepBuilder add .listener ( new CustomChunkListener () )
	 @Override beforeChunk / afterChunk / afterError
	 
	itemReader  implements [itemReader, itemReaderListener]
	 @Override read    - itemReader
	 @Override beforeRead / afterRead / afterError  -itemReaderListener
	 
	itemProcessor implements [itemProcessor , itemProcessorListener]
		@Override process - itemProcessor
		@Override beforeProcess / afterProcess / afterError - itemProcessorListener
		
	itemWriter implements 	[... , ...]
		@Override write - ...
		@Override before ... / after ...
	
	
	
