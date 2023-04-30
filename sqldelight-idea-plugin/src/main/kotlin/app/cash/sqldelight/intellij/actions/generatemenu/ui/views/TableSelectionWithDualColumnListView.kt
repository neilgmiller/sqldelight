package app.cash.sqldelight.intellij.actions.generatemenu.ui.views

import com.intellij.ui.border.CustomLineBorder
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBList
import com.intellij.util.ui.JBUI
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import javax.swing.*

class TableSelectionWithDualColumnListView : TableContextView() {

  val leftColumnList: JBList<String>
  val rightColumnList: JBList<String>

  val leftColumnListModel = DefaultListModel<String>()
  val rightColumnListModel = DefaultListModel<String>()

  val leftColumnLabel = JBLabel("Returned columns:")
  val rightColumnLabel = JBLabel("Where columns:")

  init {
    leftColumnList = JBList(leftColumnListModel)
    val leftColumnListScrollPane = JScrollPane(leftColumnList)
    leftColumnListScrollPane.border = CustomLineBorder(1, 1, 1, 1)

    rightColumnList = JBList(rightColumnListModel)
    val rightColumnScrollPane = JScrollPane(rightColumnList)
    rightColumnScrollPane.border = CustomLineBorder(1, 1, 1, 1)

    val layout = BorderLayout(5, 5)
    rootPanel.layout = layout
    rootPanel.add(menuPanel, BorderLayout.PAGE_START)

    val columnsSelectionPanel = JPanel()
    columnsSelectionPanel.layout = GridBagLayout()

    val c = GridBagConstraints()
    c.gridx = 0
    c.gridy = 0
    c.anchor = GridBagConstraints.LINE_START
    c.insets = JBUI.insetsBottom(10)
    columnsSelectionPanel.add(leftColumnLabel, c)

    c.gridx = 1
    c.insets = JBUI.insets(0, 7, 10, 0)
    columnsSelectionPanel.add(rightColumnLabel, c)

    c.gridx = 0
    c.gridy = 1
    c.insets = JBUI.insetsRight(7)
    c.weightx = 1.0
    c.weighty = 1.0
    c.fill = GridBagConstraints.BOTH
    columnsSelectionPanel.add(leftColumnListScrollPane, c)

    c.gridx = 1
    c.insets = JBUI.insetsLeft(7)
    c.fill = GridBagConstraints.BOTH
    columnsSelectionPanel.add(rightColumnScrollPane, c)

    rootPanel.add(columnsSelectionPanel, BorderLayout.CENTER)

    rootPanel.minimumSize = Dimension(400, 200)
  }

}

