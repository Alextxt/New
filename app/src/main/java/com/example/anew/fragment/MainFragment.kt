package com.example.anew.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.example.anew.CustomAdapter
import com.example.anew.MainActivity
import com.example.anew.NewItem
import com.example.anew.R

class MainFragment : Fragment(R.layout.fragmrnt_main), CustomAdapter.OnItemClickListener {

    var recyclerView: RecyclerView? = null
    var stubContainer: LinearLayout? = null
    var fragmentContainer: FrameLayout? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.main_recyclerView)
        stubContainer = view.findViewById(R.id.empty_container)
        fragmentContainer = view.findViewById(R.id.fragment_container)

        val data = ArrayList<NewItem>()

        for (i in 1..20) {
            data.add(NewItem(R.drawable.plant5, "dkcb" + i))
        }

        recyclerView?.isVisible = data.isNotEmpty()
        stubContainer?.isVisible = data.isEmpty()

        val adapter = CustomAdapter(data, this)

        recyclerView?.adapter = adapter
    }


    override fun onItemClick(position: Int) {

//    requireActivity - отдает активити в которой был открыт фрагмент
//    кастуем к MainActivity, чтобы достучаться до метода navigateToFragment
        val mainActivity = requireActivity() as MainActivity

        mainActivity.navigateToFragment(fragment = BlankFragment(), isAddToBackStack = true)
    }

    override fun onDestroyView() {
        super.onDestroyView()

 // Все вьюшки нужно занулять в методе onDestroyView, чтобы не произошло утечек памяти
        recyclerView = null
        stubContainer = null
        fragmentContainer = null
    }
}