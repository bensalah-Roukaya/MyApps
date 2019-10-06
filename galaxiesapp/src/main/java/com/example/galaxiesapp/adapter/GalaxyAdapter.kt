package adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.galaxiesapp.R
import com.example.galaxiesapp.ui.galaxy.GalaxyViewModel
import kotlinx.android.synthetic.main.galaxy_item.view.*

class GalaxyAdapter(
    ctx: Context,
    galaxies: List<GalaxyViewModel>
) :
    ArrayAdapter<GalaxyViewModel>(ctx, 0, galaxies) {

    override fun getView(position: Int, recycledView: View?, parent: ViewGroup): View {
        return this.createView(position, recycledView, parent)
    }

    override fun getDropDownView(position: Int, recycledView: View?, parent: ViewGroup): View {
        return this.createView(position, recycledView, parent)
    }

    private fun createView(position: Int, recycledView: View?, parent: ViewGroup): View {
        val galaxy = getItem(position)
        val view = recycledView ?: LayoutInflater.from(context).inflate(
            R.layout.galaxy_item,
            parent,
            false
        )
        if (galaxy != null) {
            view.item_image.setImageResource(galaxy.image)
            view.item_text.text = galaxy.title
        }
        return view
    }
}


