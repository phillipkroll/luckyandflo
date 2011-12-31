package luckyandflo

/**
 * Copyright (c) 2011, Phillip Kroll <contact@phillipkroll.de>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 *
 */

import scala.collection.mutable.ListBuffer
import xml.{NodeBuffer, Node}

class ViolationList {

  var items = new ListBuffer[Violation]

  /**
   * Serialize to string with indents
   */
  def toString(indent:String) = {
    var i = 0
    var result = ""
    for (item <- items) { i+=1; result += indent + i + ": " + item.toString  + "\n"}
    result
  }

  /**
   * Serialize to string without indents
   */
  override def toString() = toString("")

  /**
   * Serialize to XML
   */
  def toCheckStyleXml() = {
     val listBuffer = new NodeBuffer
     for (item <- items) { listBuffer &+ item.toCheckStyleXml() }
     listBuffer
  }

  /**
   * Serialize to HTML
   */
  def toHtml() = {
     val listBuffer = new NodeBuffer
     for (item <- items) { listBuffer &+ item.toHtmlList() }
     listBuffer
  }
}