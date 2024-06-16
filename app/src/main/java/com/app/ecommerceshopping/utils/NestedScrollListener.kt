package com.app.todo.utils

import androidx.core.widget.NestedScrollView

abstract class NestedScrollListener : NestedScrollView.OnScrollChangeListener {

    abstract fun isLastPage(): Boolean

    abstract fun isLoading(): Boolean

    override fun onScrollChange(
        v: NestedScrollView,
        scrollX: Int,
        scrollY: Int,
        oldScrollX: Int,
        oldScrollY: Int
    ) {
        if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight && !isLastPage()) {
            loadMoreItems()
        }
    }

    abstract fun loadMoreItems()
}
