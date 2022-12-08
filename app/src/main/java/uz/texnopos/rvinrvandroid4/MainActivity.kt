package uz.texnopos.rvinrvandroid4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import uz.texnopos.rvinrvandroid4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val rvAdapter = RVAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setMocKData()

        binding.recyclerView.adapter = rvAdapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
    }

    private fun setMocKData() {
        var i = 0
        val data = mutableListOf<RVItem>()
        repeat(20) {
            val innerData = mutableListOf<Person>()
            repeat(30) {
                innerData.add(
                    Person(i, "Name $i", "Description $i")
                )
                i++
            }
            data.add(RVItem(it, innerData))
        }

        rvAdapter.models = data
    }
}
