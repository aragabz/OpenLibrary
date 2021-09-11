package com.ragabz.openlibrary.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.ragabz.core.base.BaseViewHolder
import com.ragabz.openlibrary.R
import com.ragabz.openlibrary.databinding.ItemDocumentBinding

class DocumentsAdapter(
    var items: ObservableArrayList<DocumentItemViewModel>,
    var fragment: SearchFragment
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: ItemDocumentBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_document,
                parent,
                false
            )
        return DocumentViewHolder(binding.root)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is DocumentViewHolder) {
            val itemBinding = holder.binding as ItemDocumentBinding
            // itemBinding.imageViewChannelSubscribe.onClick {
            //     fragment.onSubscribeClick(position)
            // }
            itemBinding.apply {
                viewModel = items[position]
                executePendingBindings()
            }
        }
    }
}

class DocumentViewHolder(view: View) : BaseViewHolder(view)


@BindingAdapter("docs", "fragment")
fun bindChannelsList(
    recyclerView: RecyclerView,
    items: ObservableArrayList<DocumentItemViewModel>,
    fragment: SearchFragment
) {
    var adapter: DocumentsAdapter? = recyclerView.adapter as DocumentsAdapter?
    if (adapter == null) {
        adapter = DocumentsAdapter(items, fragment)
        recyclerView.adapter = adapter
    }
    adapter.notifyDataSetChanged()
}