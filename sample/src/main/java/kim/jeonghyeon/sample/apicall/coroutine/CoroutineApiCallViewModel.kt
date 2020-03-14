package kim.jeonghyeon.sample.apicall.coroutine

import kim.jeonghyeon.androidlibrary.architecture.livedata.LiveResource
import kim.jeonghyeon.androidlibrary.architecture.mvvm.BaseViewModel
import kim.jeonghyeon.sample.apicall.Item
import kim.jeonghyeon.sample.apicall.PostRequestBody

class CoroutineApiCallViewModel(val api: CoroutineApi) : BaseViewModel() {
    val result = LiveResource<Unit>()

    init {
        postItem(Item(1, "name"))
    }

    fun postItem(item: Item) {
        result.load {
            api.submitPost(PostRequestBody(api.getToken(), item))
        }
    }

//    fun <T> LiveResource<T>.load(action: suspend () -> T) {
//        viewModelScope.launch {
//            try {
//                postSuccess(action())
//            } catch (e: Exception) {
//                postError(kim.jeonghyeon.androidlibrary.architecture.net.error.MessageError("error occurs"))
//            }
//        }
//    }
}
