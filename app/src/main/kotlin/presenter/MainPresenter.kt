package presenter


import model.FlickrRepository
import model.Result


/**
 * Created by jeonggyuoh on 2017. 2. 24..
 */
class MainPresenter(private val adapterModel: MainContract.AdapterModel):
        MainContract.Presenter,
        FlickrRepository.FlickrEventListener {

    private val flickrRepository: FlickrRepository

    init {
        flickrRepository = FlickrRepository.getInstance()
        flickrRepository.flickrEventListener = this
    }

    override fun refresh() {
        flickrRepository.getDateByFlickr()
    }

    override fun onDataReceived(result: Result) {
        result.photos?.photo?.let {
            adapterModel.onPhotosReceived(it)
        }

    }

    override fun onError(throwable: Throwable) {
        adapterModel.onError(throwable)
    }



}
