package edu.hkbu.comp.comp4097.infoday.ui.bookmarks

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import edu.hkbu.comp.comp4097.infoday.R
import edu.hkbu.comp.comp4097.infoday.data.AppDatabase
import edu.hkbu.comp.comp4097.infoday.ui.events.DeptRecyclerViewAdapter
import edu.hkbu.comp.comp4097.infoday.ui.events.EventRecyclerViewAdapter
import edu.hkbu.comp.comp4097.infoday.ui.events.SampleData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * A fragment representing a list of Items.
 */
class BookmarkFragment : Fragment() {

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bookmark_item_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
//                adapter = BookmarkRecyclerViewAdapter(DummyContent.ITEMS)
//                adapter = BookmarkRecyclerViewAdapter(SampleData.EVENT)
                CoroutineScope(Dispatchers.IO).launch {
                    val dao = AppDatabase.getInstance(context).eventDao()
                    val events = dao.findAllBookmarkedEvents()
                    CoroutineScope(Dispatchers.Main).launch {
//                        adapter = BookmarkRecyclerViewAdapter(events)
                        adapter = BookmarkRecyclerViewAdapter(events.toMutableList())
                    }
                }
                (activity as
                        AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            BookmarkFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}