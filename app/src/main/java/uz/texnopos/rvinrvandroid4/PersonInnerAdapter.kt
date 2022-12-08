package uz.texnopos.rvinrvandroid4

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.texnopos.rvinrvandroid4.databinding.ItemPersonBinding

class PersonInnerAdapter: RecyclerView.Adapter<PersonInnerAdapter.PersonViewHolder>() {

    inner class PersonViewHolder(private val binding: ItemPersonBinding): ViewHolder(binding.root) {
        fun bind(person: Person) {
            binding.apply {
                tvName.text = person.name
                tvDescription.text = person.description
            }
        }
    }

    var models = listOf<Person>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = models.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        val binding = ItemPersonBinding.bind(view)
        return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(models[position])
    }
}
