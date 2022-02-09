package controllers

import javax.inject._
import play.api.mvc._

import java.io.File



@Singleton
class HomeController @Inject()(cc: ControllerComponents) (implicit assetsFinder: AssetsFinder)
  extends AbstractController(cc) {

  def index = Action {
    println(getListOfFiles("C:\\Temp"))
    Ok("Ca braque !!!!")
  }

  def getListOfFiles(dir: String): List[File] = {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      d.listFiles().filter(_.isFile).toList
    } else {
      List[File]()
    }
  }
}
