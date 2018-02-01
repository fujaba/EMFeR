package emfer.examples.roadwork;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.mapeditor.core.Map;
import org.mapeditor.core.MapLayer;
import org.mapeditor.core.Tile;
import org.mapeditor.core.TileLayer;
import org.mapeditor.core.TileSet;
import org.mapeditor.io.TMXMapReader;
import org.mapeditor.view.IsometricRenderer;
import org.mapeditor.view.MapRenderer;

import emfer.EMFeR;
import emfer.reachability.ReachableState;

public class TMXRoadworkVisualizer
{

   public static class Position
   {
      private int x;

      private int y;


      public Position(int x, int y)
      {
         this.x = x;
         this.y = y;
      }
   }


   public static void visualize(EMFeR emfer, String prePath) throws Exception
   {
      // ArrayList<TrafoApplication> examplePath = rwp.examplePath;

      TMXMapReader tmxReader = new TMXMapReader();
      TMXMapReader.checkRoot("assets");
      Map map = tmxReader.readMap("assets/roadwork.tmx");

      MapRenderer renderer = new IsometricRenderer(map);

      boolean success = writeImage(map, renderer, prePath + "roadworkTest.png");

      System.out.println(map.toString() + " loaded " + (success ? "successfully" : "unsuccessfully"));

      // layer
      TileLayer carsWLayer = null;
      TileLayer carsELayer = null;
      TileLayer emptyLayer = null;
      for (MapLayer layer : map.getLayers())
      {
         if (layer.getName().equals("carsW"))
         {
            carsWLayer = (TileLayer) layer;
         }
         if (layer.getName().equals("carsE"))
         {
            carsELayer = (TileLayer) layer;
         }
         if (layer.getName().equals("empty"))
         {
            emptyLayer = (TileLayer) layer;
         }
      }
      HashMap<String, Position> nameTileMap = new HashMap<String, Position>();
      nameTileMap.put("n1", new Position(1, 0));
      nameTileMap.put("n2", new Position(1, 1));
      nameTileMap.put("n3", new Position(1, 2));
      nameTileMap.put("n4", new Position(1, 3));
      nameTileMap.put("n5", new Position(1, 4));
      nameTileMap.put("n6", new Position(1, 5));
      nameTileMap.put("n7", new Position(1, 6));
      nameTileMap.put("s1", new Position(1, 6));
      nameTileMap.put("s2", new Position(1, 5));
      nameTileMap.put("s6", new Position(1, 1));
      nameTileMap.put("s7", new Position(1, 0));

      // tilesets
      TileSet carsWTileset = null;
      TileSet carsETileset = null;
      for (TileSet tileSet : map.getTileSets())
      {
         if (tileSet.getName().equals("carsW"))
         {
            carsWTileset = tileSet;
         }
         if (tileSet.getName().equals("carsE"))
         {
            carsETileset = tileSet;
         }
      }

      // int i = 0;
      // for (TrafoApplication trafoApplication : examplePath)
      // {
      // ReachableState state = trafoApplication.getSrc();
      // carsWLayer.copyFrom(emptyLayer);
      // carsELayer.copyFrom(emptyLayer);
      //
      // RoadMap rm = (RoadMap) state.getRoot();
      // for (Car car : rm.getCars())
      // {
      // Track track = car.getTrack();
      // TravelDirection travelDirection = car.getTravelDirection();
      // TileSet tileSet = null;
      // Tile carTile = null;
      // TileLayer layer = null;
      // if (track.getTravelDirection() == TravelDirection.EAST)
      // {
      // tileSet = carsETileset;
      // }
      // else
      // {
      // tileSet = carsWTileset;
      // }
      //
      // if (travelDirection == TravelDirection.EAST)
      // {
      // carTile = tileSet.getTile(1);
      // layer = carsELayer;
      // }
      // else
      // {
      // carTile = tileSet.getTile(0);
      // layer = carsWLayer;
      // }
      //
      // Position position = nameTileMap.get(track.getName());
      // layer.setTileAt(position.x, position.y, carTile);
      //
      // }
      // writeImage(map, renderer, "statePath" + i++ + ".png");
      //
      // }

      // export one image per state
      for (ReachableState state : emfer.getReachabilityGraph().getStates())
      {
         carsWLayer.copyFrom(emptyLayer);
         carsELayer.copyFrom(emptyLayer);

         RoadMap rm = (RoadMap) state.getRoot();
         for (Car car : rm.getCars())
         {
            Track track = car.getTrack();
            TravelDirection travelDirection = car.getTravelDirection();
            TileSet tileSet = null;
            Tile carTile = null;
            TileLayer layer = null;
            if (track.getTravelDirection() == TravelDirection.EAST)
            {
               tileSet = carsETileset;
            }
            else
            {
               tileSet = carsWTileset;
            }

            if (travelDirection == TravelDirection.EAST)
            {
               carTile = tileSet.getTile(1);
               layer = carsELayer;
            }
            else
            {
               carTile = tileSet.getTile(0);
               layer = carsWLayer;
            }

            Position position = nameTileMap.get(track.getName());
            layer.setTileAt(position.x, position.y, carTile);

         }
         writeImage(map, renderer, prePath + "state" + state.hashCode() + ".png");
      }
      return;
   }


   public static boolean writeImage(Map map, MapRenderer renderer, String path)
   {
      int width = map.getWidth() * map.getTileWidth() * 2;
      int height = map.getHeight() * map.getTileHeight();
      BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

      Graphics2D g = bi.createGraphics();
      g.setClip(0, 0, width, height);

      final Graphics2D g2d = (Graphics2D) g.create();
      final Rectangle clip = g2d.getClipBounds();

      // Draw a gray background
      g2d.setPaint(new Color(100, 100, 100));
      g2d.fill(clip);

      // g2d.setClip(50, 50, g2d.getClipBounds().width, g2d.getClipBounds().height);

      // Draw each map layer
      for (MapLayer layer : map.getLayers())
      {
         Position translate = new Position(50, 50);

         if (layer instanceof TileLayer)
         {
            if (layer.getName().equals("carsW"))
            {
               translate.x = 50;
               translate.y = 90;
            }
            if (layer.getName().equals("carsE"))
            {
               translate.x = 50;
               translate.y = 90;
            }
            if (layer.getName().equals("lights"))
            {
               translate.x = 50;
               translate.y = 80;
            }
            if (layer.getName().equals("road"))
            {
               translate.x = 50;
               translate.y = 50;
            }
         }
         g2d.translate(translate.x, translate.y);
         renderer.paintTileLayer(g2d, (TileLayer) layer);
         g2d.translate(-translate.x, -translate.y);
      }
      try
      {
         return ImageIO.write(bi, "PNG", new File(path));
      }
      catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
         return false;
      }
   }
}
