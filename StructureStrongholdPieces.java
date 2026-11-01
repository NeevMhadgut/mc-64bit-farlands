import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StructureStrongholdPieces {
   private static final ahh[] b = new ahh[]{
      new ahh(ComponentStrongholdStraight.class, 40, 0),
      new ahh(ComponentStrongholdPrison.class, 5, 5),
      new ahh(ComponentStrongholdLeftTurn.class, 20, 0),
      new ahh(ComponentStrongholdRightTurn.class, 20, 0),
      new ahh(ComponentStrongholdRoomCrossing.class, 10, 6),
      new ahh(ComponentStrongholdStairsStraight.class, 5, 5),
      new ahh(ComponentStrongholdStairs.class, 5, 5),
      new ahh(ComponentStrongholdCrossing.class, 5, 4),
      new ahh(ComponentStrongholdChestCorridor.class, 5, 4),
      new as(ComponentStrongholdLibrary.class, 10, 2),
      new ar(ComponentStrongholdPortalRoom.class, 20, 1)
   };
   private static List c;
   private static Class d;
   static int a = 0;
   private static final StructureStrongholdStones e = new StructureStrongholdStones(null);

   public static void a() {
      c = new ArrayList();

      for (ahh structurestrongholdpieceweight : b) {
         structurestrongholdpieceweight.c = 0;
         c.add(structurestrongholdpieceweight);
      }

      d = null;
   }

   private static boolean c() {
      boolean flag = false;
      a = 0;

      for (ahh structurestrongholdpieceweight : c) {
         if (structurestrongholdpieceweight.d > 0 && structurestrongholdpieceweight.c < structurestrongholdpieceweight.d) {
            flag = true;
         }

         a = a + structurestrongholdpieceweight.b;
      }

      return flag;
   }

   private static ComponentStronghold getStrongholdComponentFromWeightedPiece(
      Class par0Class, List par1List, Random par2Random, long par3, int par4, long par5, int par6, int par7
   ) {
      Object obj = null;
      if (par0Class == ComponentStrongholdStraight.class) {
         obj = ComponentStrongholdStraight.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (par0Class == ComponentStrongholdPrison.class) {
         obj = ComponentStrongholdPrison.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (par0Class == ComponentStrongholdLeftTurn.class) {
         obj = ComponentStrongholdLeftTurn.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (par0Class == ComponentStrongholdRightTurn.class) {
         obj = ComponentStrongholdRightTurn.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (par0Class == ComponentStrongholdRoomCrossing.class) {
         obj = ComponentStrongholdRoomCrossing.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (par0Class == ComponentStrongholdStairsStraight.class) {
         obj = ComponentStrongholdStairsStraight.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (par0Class == ComponentStrongholdStairs.class) {
         obj = ComponentStrongholdStairs.getStrongholdStairsComponent(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (par0Class == ComponentStrongholdCrossing.class) {
         obj = ComponentStrongholdCrossing.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (par0Class == ComponentStrongholdChestCorridor.class) {
         obj = ComponentStrongholdChestCorridor.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (par0Class == ComponentStrongholdLibrary.class) {
         obj = ComponentStrongholdLibrary.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (par0Class == ComponentStrongholdPortalRoom.class) {
         obj = ComponentStrongholdPortalRoom.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
      }

      return (ComponentStronghold)obj;
   }

   private static ComponentStronghold getNextComponent(s par0ComponentStrongholdStairs2, List par1List, Random par2Random, long par3, int par4, long par5, int par6, int par7) {
      if (!c()) {
         return null;
      }

      if (d != null) {
         ComponentStronghold var8x = getStrongholdComponentFromWeightedPiece(d, par1List, par2Random, par3, par4, par5, par6, par7);
         d = null;
         if (var8x != null) {
            return var8x;
         }
      }

      int var13 = 0;

      while (var13 < 5) {
         var13++;
         int var9x = par2Random.nextInt(a);

         for (ahh var11 : c) {
            var9x -= var11.b;
            if (var9x < 0) {
               if (!var11.a(par7) || var11 == par0ComponentStrongholdStairs2.a) {
                  break;
               }

               ComponentStronghold var12 = getStrongholdComponentFromWeightedPiece(var11.a, par1List, par2Random, par3, par4, par5, par6, par7);
               if (var12 != null) {
                  var11.c++;
                  par0ComponentStrongholdStairs2.a = var11;
                  if (!var11.a()) {
                     c.remove(var11);
                  }

                  return var12;
               }
            }
         }
      }

      StructureBoundingBox var14 = ComponentStrongholdCorridor.func_35051_a(par1List, par2Random, par3, par4, par5, par6);
      return var14 != null && var14.b > 1 ? new ComponentStrongholdCorridor(par7, par2Random, var14, par6) : null;
   }

   private static StructureComponent getNextValidComponent(
      s par0ComponentStrongholdStairs2, List par1List, Random par2Random, long par3, int par4, long par5, int par6, int par7
   ) {
      if (par7 > 50) {
         return null;
      }

      if (Math.abs(par3 - par0ComponentStrongholdStairs2.b().a) <= 112L && Math.abs(par5 - par0ComponentStrongholdStairs2.b().c) <= 112L) {
         ComponentStronghold componentstronghold = getNextComponent(par0ComponentStrongholdStairs2, par1List, par2Random, par3, par4, par5, par6, par7 + 1);
         if (componentstronghold != null) {
            par1List.add(componentstronghold);
            par0ComponentStrongholdStairs2.c.add(componentstronghold);
         }

         return componentstronghold;
      } else {
         return null;
      }
   }

   static StructureComponent getNextValidComponentAccess(s par0ComponentStrongholdStairs2, List par1List, Random par2Random, long par3, int par4, long par5, int par6, int par7) {
      return getNextValidComponent(par0ComponentStrongholdStairs2, par1List, par2Random, par3, par4, par5, par6, par7);
   }

   static Class a(Class par0Class) {
      d = par0Class;
      return par0Class;
   }

   static StructureStrongholdStones b() {
      return e;
   }
}
