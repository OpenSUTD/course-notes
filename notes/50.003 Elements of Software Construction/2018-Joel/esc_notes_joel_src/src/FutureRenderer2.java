public class FutureRenderer2 {
	private final ExecutorService executor = new ScheduledThreadPoolExecutor (100);
	
	void renderPage (CharSequence source) throws Exception {
		final List<ImageInfo> imageInfos = scanForImageInfo(source);
		
		Callable<List<ImageData>> task = new Callable<List<ImageData>>() {
			public List<ImageData> call () {
				List<ImageData> result = new ArrayList<ImageData>();
				for (ImageInfo imageInfo : imageInfos) {
					result.add(imageInfo.downloadImage());
				}
				
				return result; 
			}
		};
		
		Future<List<ImageData>> future = executor.submit(task);
		renderText(source);
		
		try {
			List<ImageData> imageData = future.get(3, TimeUnit.SECONDS);
			for (ImageData data: imageData) {
				renderImage(data);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			future.cancel(true);
		} catch (TimeoutException e) {
			renderCross();
		}
	}
	private void renderCross() { /* TODO Auto-generated method stub */ }
	private void renderImage(ImageData data) { /* TODO Auto-generated method stub */ }
	private void renderText(CharSequence source) { /* TODO Auto-generated method stub */ }
	private List<ImageInfo> scanForImageInfo(CharSequence source) { return null; }
}