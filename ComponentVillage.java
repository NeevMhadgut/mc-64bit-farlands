import java.util.List;
import java.util.Random;

abstract class ComponentVillage extends StructureComponent {
   private int a;

   protected ComponentVillage(int par1) {
      super(par1);
   }

   protected StructureComponent getNextComponentNN(g par1ComponentVillageStartPiece, List par2List, Random par3Random, int par4, long par5) {
      switch (this.h) {
         case 0:
            return StructureVillagePieces.getNextStructureComponent(
               par1ComponentVillageStartPiece, par2List, par3Random, this.g.a - 1L, this.g.b + par4, this.g.c + par5, 1, this.c()
            );
         case 1:
            return StructureVillagePieces.getNextStructureComponent(
               par1ComponentVillageStartPiece, par2List, par3Random, this.g.a + par5, this.g.b + par4, this.g.c - 1L, 2, this.c()
            );
         case 2:
            return StructureVillagePieces.getNextStructureComponent(
               par1ComponentVillageStartPiece, par2List, par3Random, this.g.a - 1L, this.g.b + par4, this.g.c + par5, 1, this.c()
            );
         case 3:
            return StructureVillagePieces.getNextStructureComponent(
               par1ComponentVillageStartPiece, par2List, par3Random, this.g.a + par5, this.g.b + par4, this.g.c - 1L, 2, this.c()
            );
         default:
            return null;
      }
   }

   protected StructureComponent getNextComponentPP(g par1ComponentVillageStartPiece, List par2List, Random par3Random, int par4, long par5) {
      switch (this.h) {
         case 0:
            return StructureVillagePieces.getNextStructureComponent(
               par1ComponentVillageStartPiece, par2List, par3Random, this.g.d + 1L, this.g.b + par4, this.g.c + par5, 3, this.c()
            );
         case 1:
            return StructureVillagePieces.getNextStructureComponent(
               par1ComponentVillageStartPiece, par2List, par3Random, this.g.a + par5, this.g.b + par4, this.g.f + 1L, 0, this.c()
            );
         case 2:
            return StructureVillagePieces.getNextStructureComponent(
               par1ComponentVillageStartPiece, par2List, par3Random, this.g.d + 1L, this.g.b + par4, this.g.c + par5, 3, this.c()
            );
         case 3:
            return StructureVillagePieces.getNextStructureComponent(
               par1ComponentVillageStartPiece, par2List, par3Random, this.g.a + par5, this.g.b + par4, this.g.f + 1L, 0, this.c()
            );
         default:
            return null;
      }
   }

   protected int b(World par1World, StructureBoundingBox par2StructureBoundingBox) {
      int i = 0;
      int j = 0;

      for (long k = this.g.c; k <= this.g.f; k++) {
         for (long l = this.g.a; l <= this.g.d; l++) {
            if (par2StructureBoundingBox.isVecInside(l, 64, k)) {
               i += Math.max(par1World.getTopSolidOrLiquidBlock(l, k), par1World.t.h());
               j++;
            }
         }
      }

      return j == 0 ? -1 : i / j;
   }

   protected static boolean a(StructureBoundingBox par0StructureBoundingBox) {
      return par0StructureBoundingBox != null && par0StructureBoundingBox.b > 10;
   }

   protected void spawnVillagers(World par1World, StructureBoundingBox par2StructureBoundingBox, long par3, int par4, long par5, int par6) {
      if (this.a < par6) {
         for (int i = this.a; i < par6; i++) {
            long j = this.getXWithOffset(par3 + i, par5);
            int k = this.b(par4);
            long l = this.getZWithOffset(par3 + i, par5);
            if (!par2StructureBoundingBox.isVecInside(j, k, l)) {
               break;
            }

            this.a++;
            EntityVillager entityvillager = new EntityVillager(par1World, this.a(i));
            entityvillager.c(j + 0.5, k, l + 0.5, 0.0F, 0.0F);
            par1World.a(entityvillager);
         }
      }
   }

   protected int a(int par1) {
      return 0;
   }
}
