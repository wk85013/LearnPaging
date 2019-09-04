package com.qingmei2.samplepaging.viewmodel

import android.app.Application
import android.nfc.tech.MifareUltralight
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.qingmei2.samplepaging.db.Student
import com.qingmei2.samplepaging.db.StudentDb

class CommonViewModel(app: Application) : AndroidViewModel(app) {

    private val dao = StudentDb.get(app).studentDao()

    fun getRefreshLiveData(): LiveData<PagedList<Student>> =
            LivePagedListBuilder(dao.getAllStudent(), PagedList.Config.Builder()
                    .setPageSize(5)                         //配置分页加载的数量
                    .setEnablePlaceholders(ENABLE_PLACEHOLDERS)     //配置是否启动PlaceHolders
                    .setInitialLoadSizeHint(PAGE_SIZE)              //初始化加载的数量
                    .build()).build()

    companion object {

        private const val PAGE_SIZE = 15

        private const val ENABLE_PLACEHOLDERS = false
    }
}