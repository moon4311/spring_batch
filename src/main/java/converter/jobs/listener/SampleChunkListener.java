package converter.jobs.listener;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

public class SampleChunkListener implements ChunkListener{

	@Override
	public void beforeChunk(ChunkContext context) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterChunk(ChunkContext context) {
		
	}
	@Override
	public void afterChunkError(ChunkContext context) {
		// TODO Auto-generated method stub
		
	}
}
