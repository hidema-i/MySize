package android.example.mysize

import android.example.mysize.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //アクティビティのonCreateメソッドが呼ばれるタイミングでSharedPreferencesのインスタンスを取得し、
        //共有プレファレンスから保存されている値を定数に取得している
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editNeck = pref.getString("NECK","")
        val editSleeve = pref.getString("SLEEVE","")
        val editWaist = pref.getString("WAIST","")
        val editInseam = pref.getString("INSEAM","")

        //値を各EditTextに表示させる
        binding.neck.setText(editNeck)
        binding.sleeve.setText(editSleeve)
        binding.waist.setText(editWaist)
        binding.inseam.setText(editInseam)
        //saveButtonのリスナーを設定
        binding.save.setOnClickListener { onSaveTapped() }
    }
    //saveButtonの処理
    private fun onSaveTapped() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.edit {
            putString("NECK",binding.neck.text.toString())
            putString("SLEEVE",binding.sleeve.text.toString())
            putString("WAIST",binding.waist.text.toString())
            putString("INSEAM",binding.inseam.text.toString())
        }
    }


}