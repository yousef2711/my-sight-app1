package com.yousef.mysight00.ui.adapter

import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.yousef.mysight00.R
import com.yousef.mysight00.databinding.ItemTaskBinding
import com.yousef.mysight00.ui.model.TaskModel

class TaskAdapter(private val taskList: List<TaskModel>, private val listener: TaskActionListener) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(task: TaskModel, listener: TaskActionListener) {
            binding.taskTitle.text = task.name
            binding.taskDate.text = task.date

            // تحديث شكل الزر بناءً على الحالة
            updateButtonUI(task)

            // عند الضغط على زر الصح/الغلط
            binding.btnCorrect.setOnClickListener {
                task.isCorrect = !task.isCorrect
                updateButtonUI(task)
            }

            // عند الضغط على زر الثلاث نقاط
            binding.btnMore.setOnClickListener { showPopupMenu(it, task, listener) }
        }

        // ✅ تحديث الخلفية والأيقونة عند تغيير الحالة
        private fun updateButtonUI(task: TaskModel) {
            val context = binding.root.context

            if (task.isCorrect) {
                binding.btnCorrect.setImageResource(R.drawable.ic_check)
                binding.btnCorrect.background = ContextCompat.getDrawable(context, R.drawable.bg_green_circle)
            } else {
                binding.btnCorrect.setImageResource(R.drawable.ic_wrong)
                binding.btnCorrect.background = ContextCompat.getDrawable(context, R.drawable.bg_wrong)
            }
        }

        // ✅ إظهار القائمة المنبثقة عند الضغط على زر الثلاث نقاط
        private fun showPopupMenu(view: View, task: TaskModel, listener: TaskActionListener) {
            val popup = PopupMenu(view.context, view)
            val inflater: MenuInflater = popup.menuInflater
            inflater.inflate(R.menu.menu_task_options, popup.menu)

            popup.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.action_send -> {
                        listener.onSendTask(task)
                        true
                    }
                    R.id.action_delete -> {
                        listener.onDeleteTask(task)
                        true
                    }
                    R.id.action_edit -> {
                        listener.onEditTask(task)
                        true
                    }
                    else -> false
                }
            }

            popup.show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(taskList[position], listener)
    }

    override fun getItemCount(): Int = taskList.size
}

// ✅ واجهة لتحديد الإجراءات عند اختيار عنصر من القائمة
interface TaskActionListener {
    fun onSendTask(task: TaskModel)
    fun onDeleteTask(task: TaskModel)
    fun onEditTask(task: TaskModel)
}
