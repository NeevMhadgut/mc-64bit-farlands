import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class StructureVillagePieces {
   public static ArrayList a(Random par0Random, int par1) {
      ArrayList arraylist = new ArrayList();
      arraylist.add(new dt(ComponentVillageHouse4_Garden.class, 4, MathHelper.a(par0Random, 2 + par1, 4 + par1 * 2)));
      arraylist.add(new dt(ComponentVillageChurch.class, 20, MathHelper.a(par0Random, 0 + par1, 1 + par1)));
      arraylist.add(new dt(ComponentVillageHouse1.class, 20, MathHelper.a(par0Random, 0 + par1, 2 + par1)));
      arraylist.add(new dt(ComponentVillageWoodHut.class, 3, MathHelper.a(par0Random, 2 + par1, 5 + par1 * 3)));
      arraylist.add(new dt(p.class, 15, MathHelper.a(par0Random, 0 + par1, 2 + par1)));
      arraylist.add(new dt(k.class, 3, MathHelper.a(par0Random, 1 + par1, 4 + par1)));
      arraylist.add(new dt(ComponentVillageField2.class, 3, MathHelper.a(par0Random, 2 + par1, 4 + par1 * 2)));
      arraylist.add(new dt(ComponentVillageHouse2.class, 15, MathHelper.a(par0Random, 0, 1 + par1)));
      arraylist.add(new dt(ComponentVillageHouse3.class, 8, MathHelper.a(par0Random, 0 + par1, 3 + par1 * 2)));
      Iterator iterator = arraylist.iterator();

      while (iterator.hasNext()) {
         if (((dt)iterator.next()).d == 0) {
            iterator.remove();
         }
      }

      return arraylist;
   }

   private static int a(ArrayList par0ArrayList) {
      boolean flag = false;
      int i = 0;

      for (dt structurevillagepieceweight : par0ArrayList) {
         if (structurevillagepieceweight.d > 0 && structurevillagepieceweight.c < structurevillagepieceweight.d) {
            flag = true;
         }

         i += structurevillagepieceweight.b;
      }

      return flag ? i : -1;
   }

   private static ComponentVillage getVillageComponentFromWeightedPiece(
      dt par0StructureVillagePieceWeight, List par1List, Random par2Random, long par3, int par4, long par5, int par6, int par7
   ) {
      Class class1 = par0StructureVillagePieceWeight.a;
      Object obj = null;
      if (class1 == ComponentVillageHouse4_Garden.class) {
         obj = ComponentVillageHouse4_Garden.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (class1 == ComponentVillageChurch.class) {
         obj = ComponentVillageChurch.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (class1 == ComponentVillageHouse1.class) {
         obj = ComponentVillageHouse1.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (class1 == ComponentVillageWoodHut.class) {
         obj = ComponentVillageWoodHut.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (class1 == p.class) {
         obj = p.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (class1 == k.class) {
         obj = k.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (class1 == ComponentVillageField2.class) {
         obj = ComponentVillageField2.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (class1 == ComponentVillageHouse2.class) {
         obj = ComponentVillageHouse2.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
      } else if (class1 == ComponentVillageHouse3.class) {
         obj = ComponentVillageHouse3.findValidPlacement(par1List, par2Random, par3, par4, par5, par6, par7);
      }

      return (ComponentVillage)obj;
   }

   private static ComponentVillage getNextVillageComponent(
      g par0ComponentVillageStartPiece, List par1List, Random par2Random, long par3, int par4, long par5, int par6, int par7
   ) {
      int var8x = a(par0ComponentVillageStartPiece.d);
      if (var8x <= 0) {
         return null;
      }

      int var9x = 0;

      while (var9x < 5) {
         var9x++;
         int var10 = par2Random.nextInt(var8x);

         for (dt var12 : par0ComponentVillageStartPiece.d) {
            var10 -= var12.b;
            if (var10 < 0) {
               if (!var12.a(par7) || var12 == par0ComponentVillageStartPiece.c && par0ComponentVillageStartPiece.d.size() > 1) {
                  break;
               }

               ComponentVillage var13 = getVillageComponentFromWeightedPiece(var12, par1List, par2Random, par3, par4, par5, par6, par7);
               if (var13 != null) {
                  var12.c++;
                  par0ComponentVillageStartPiece.c = var12;
                  if (!var12.a()) {
                     par0ComponentVillageStartPiece.d.remove(var12);
                  }

                  return var13;
               }
            }
         }
      }

      StructureBoundingBox var14 = ComponentVillageTorch.findValidPlacement(par1List, par2Random, par3, par4, par5, par6);
      return var14 != null ? new ComponentVillageTorch(par7, par2Random, var14, par6) : null;
   }

   private static StructureComponent getNextVillageStructureComponent(
      g par0ComponentVillageStartPiece, List par1List, Random par2Random, long par3, int par4, long par5, int par6, int par7
   ) {
      if (par7 > 50) {
         return null;
      }

      if (Math.abs(par3 - par0ComponentVillageStartPiece.b().a) <= 112L && Math.abs(par5 - par0ComponentVillageStartPiece.b().c) <= 112L) {
         ComponentVillage componentvillage = getNextVillageComponent(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7 + 1);
         if (componentvillage != null) {
            long i = (componentvillage.g.a + componentvillage.g.d) / 2L;
            long j = (componentvillage.g.c + componentvillage.g.f) / 2L;
            long k = componentvillage.g.d - componentvillage.g.a;
            long l = componentvillage.g.f - componentvillage.g.c;
            long i1 = k <= l ? l : k;
            if (par0ComponentVillageStartPiece.a().areBiomesViable(i, j, i1 / 2L + 4L, MapGenVillage.a)) {
               par1List.add(componentvillage);
               par0ComponentVillageStartPiece.e.add(componentvillage);
               return componentvillage;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private static StructureComponent getNextComponentVillagePath(
      g par0ComponentVillageStartPiece, List par1List, Random par2Random, long par3, int par4, long par5, int par6, int par7
   ) {
      if (par7 > 3 + par0ComponentVillageStartPiece.b) {
         return null;
      }

      if (Math.abs(par3 - par0ComponentVillageStartPiece.b().a) <= 112L && Math.abs(par5 - par0ComponentVillageStartPiece.b().c) <= 112L) {
         StructureBoundingBox structureboundingbox = ComponentVillagePathGen.func_35087_a(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6);
         if (structureboundingbox != null && structureboundingbox.b > 10) {
            ComponentVillagePathGen componentvillagepathgen = new ComponentVillagePathGen(par7, par2Random, structureboundingbox, par6);
            long i = (componentvillagepathgen.g.a + componentvillagepathgen.g.d) / 2L;
            long j = (componentvillagepathgen.g.c + componentvillagepathgen.g.f) / 2L;
            long k = componentvillagepathgen.g.d - componentvillagepathgen.g.a;
            long l = componentvillagepathgen.g.f - componentvillagepathgen.g.c;
            long i1 = k <= l ? l : k;
            if (par0ComponentVillageStartPiece.a().areBiomesViable(i, j, i1 / 2L + 4L, MapGenVillage.a)) {
               par1List.add(componentvillagepathgen);
               par0ComponentVillageStartPiece.f.add(componentvillagepathgen);
               return componentvillagepathgen;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   static StructureComponent getNextStructureComponent(g par0ComponentVillageStartPiece, List par1List, Random par2Random, long par3, int par4, long par5, int par6, int par7) {
      return getNextVillageStructureComponent(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7);
   }

   static StructureComponent getNextStructureComponentVillagePath(
      g par0ComponentVillageStartPiece, List par1List, Random par2Random, long par3, int par4, long par5, int par6, int par7
   ) {
      return getNextComponentVillagePath(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7);
   }
}
