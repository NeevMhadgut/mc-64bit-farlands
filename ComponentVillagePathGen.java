import java.util.List;
import java.util.Random;

public class ComponentVillagePathGen extends cf {
   private int a;

   public ComponentVillagePathGen(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
      this.a = Math.max(par3StructureBoundingBox.b(), par3StructureBoundingBox.d());
   }

   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      boolean flag = false;

      for (int i = par3Random.nextInt(5); i < this.a - 8; i += 2 + par3Random.nextInt(5)) {
         StructureComponent structurecomponent = this.getNextComponentNN((g)par1StructureComponent, par2List, par3Random, 0, i);
         if (structurecomponent != null) {
            i += Math.max(structurecomponent.g.b(), structurecomponent.g.d());
            flag = true;
         }
      }

      for (int j = par3Random.nextInt(5); j < this.a - 8; j += 2 + par3Random.nextInt(5)) {
         StructureComponent structurecomponent1 = this.getNextComponentPP((g)par1StructureComponent, par2List, par3Random, 0, j);
         if (structurecomponent1 != null) {
            j += Math.max(structurecomponent1.g.b(), structurecomponent1.g.d());
            flag = true;
         }
      }

      if (flag && par3Random.nextInt(3) > 0) {
         switch (this.h) {
            case 0:
               StructureVillagePieces.getNextStructureComponentVillagePath((g)par1StructureComponent, par2List, par3Random, this.g.a - 1L, this.g.b, this.g.f - 2L, 1, this.c());
               break;
            case 1:
               StructureVillagePieces.getNextStructureComponentVillagePath((g)par1StructureComponent, par2List, par3Random, this.g.a, this.g.b, this.g.c - 1L, 2, this.c());
               break;
            case 2:
               StructureVillagePieces.getNextStructureComponentVillagePath((g)par1StructureComponent, par2List, par3Random, this.g.a - 1L, this.g.b, this.g.c, 1, this.c());
               break;
            case 3:
               StructureVillagePieces.getNextStructureComponentVillagePath((g)par1StructureComponent, par2List, par3Random, this.g.d - 2L, this.g.b, this.g.c - 1L, 2, this.c());
         }
      }

      if (flag && par3Random.nextInt(3) > 0) {
         switch (this.h) {
            case 0:
               StructureVillagePieces.getNextStructureComponentVillagePath((g)par1StructureComponent, par2List, par3Random, this.g.d + 1L, this.g.b, this.g.f - 2L, 3, this.c());
               break;
            case 1:
               StructureVillagePieces.getNextStructureComponentVillagePath((g)par1StructureComponent, par2List, par3Random, this.g.a, this.g.b, this.g.f + 1L, 0, this.c());
               break;
            case 2:
               StructureVillagePieces.getNextStructureComponentVillagePath((g)par1StructureComponent, par2List, par3Random, this.g.d + 1L, this.g.b, this.g.c, 3, this.c());
               break;
            case 3:
               StructureVillagePieces.getNextStructureComponentVillagePath((g)par1StructureComponent, par2List, par3Random, this.g.d - 2L, this.g.b, this.g.f + 1L, 0, this.c());
         }
      }
   }

   public static StructureBoundingBox func_35087_a(g par0ComponentVillageStartPiece, List par1List, Random par2Random, long par3, int par4, long par5, int par6) {
      for (int i = 7 * MathHelper.a(par2Random, 3, 5); i >= 7; i -= 7) {
         StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par3, par4, par5, 0L, 0, 0L, 3L, 3, i, par6);
         if (StructureComponent.a(par1List, structureboundingbox) == null) {
            return structureboundingbox;
         }
      }

      return null;
   }

   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      for (long i = this.g.a; i <= this.g.d; i++) {
         for (long j = this.g.c; j <= this.g.f; j++) {
            if (par3StructureBoundingBox.isVecInside(i, 64, j)) {
               int k = par1World.getTopSolidOrLiquidBlock(i, j) - 1;
               par1World.setBlock(i, k, j, Block.F.bO);
            }
         }
      }

      return true;
   }
}
