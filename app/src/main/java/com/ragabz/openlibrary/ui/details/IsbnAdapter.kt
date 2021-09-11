package com.ragabz.openlibrary.ui.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.ragabz.core.base.BaseViewHolder
import com.ragabz.openlibrary.R
import com.ragabz.openlibrary.databinding.ItemIsbnBinding
import com.ragabz.openlibrary.utils.getIsbnImage

class IsbnAdapter(
    var items: ObservableArrayList<String>,
    var fragment: DocumentDetailsFragment
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: ItemIsbnBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_isbn,
                parent,
                false
            )
        return IsbnViewHolder(binding.root)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is IsbnViewHolder) {
            val itemBinding = holder.binding as ItemIsbnBinding
            itemBinding.apply {
                image = getIsbnImage(items[position])
                executePendingBindings()
            }
        }
    }
}

class IsbnViewHolder(view: View) : BaseViewHolder(view)

@BindingAdapter("isbnList", "fragment")
fun bindIsbnList(
    recyclerView: RecyclerView,
    items: ObservableArrayList<String>,
    fragment: DocumentDetailsFragment
) {
    var adapter: IsbnAdapter? = recyclerView.adapter as IsbnAdapter?
    if (adapter == null) {
        adapter = IsbnAdapter(items, fragment)
        recyclerView.adapter = adapter
    }
    adapter.notifyDataSetChanged()
}