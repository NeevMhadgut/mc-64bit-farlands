import java.util.List;
import java.util.Random;

public class ComponentMineshaftCorridor extends StructureComponent {
   private final boolean a;
   private final boolean b;
   private boolean c;
   private int d;

   public ComponentMineshaftCorridor(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
      this.a = par2Random.nextInt(3) == 0;
      this.b = !this.a && par2Random.nextInt(23) == 0;
      if (this.h != 2 && this.h != 0) {
         this.d = par3StructureBoundingBox.b() / 5;
      } else {
         this.d = par3StructureBoundingBox.d() / 5;
      }
   }

   public static StructureBoundingBox findValidPlacement(List par0List, Random par1Random, long par2, int par3, long par4, int par5) {
      StructureBoundingBox structureboundingbox = new StructureBoundingBox(par2, par3, par4, par2, par3 + 2, par4);

      int i;
      for (i = par1Random.nextInt(3) + 2; i > 0; i--) {
         int j = i * 5;
         switch (par5) {
            case 0:
               structureboundingbox.d = par2 + 2L;
               structureboundingbox.f = par4 + (j - 1);
               break;
            case 1:
               structureboundingbox.a = par2 - (j - 1);
               structureboundingbox.f = par4 + 2L;
               break;
            case 2:
               structureboundingbox.d = par2 + 2L;
               structureboundingbox.c = par4 - (j - 1);
               break;
            case 3:
               structureboundingbox.d = par2 + (j - 1);
               structureboundingbox.f = par4 + 2L;
         }

         if (StructureComponent.a(par0List, structureboundingbox) == null) {
            break;
         }
      }

      return i > 0 ? structureboundingbox : null;
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      int i = this.c();
      int j = par3Random.nextInt(4);
      switch (this.h) {
         case 0:
            if (j <= 1) {
               StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a, this.g.b - 1 + par3Random.nextInt(3), this.g.f + 1L, this.h, i);
            } else if (j == 2) {
               StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a - 1L, this.g.b - 1 + par3Random.nextInt(3), this.g.f - 3L, 1, i);
            } else {
               StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.d + 1L, this.g.b - 1 + par3Random.nextInt(3), this.g.f - 3L, 3, i);
            }
            break;
         case 1:
            if (j <= 1) {
               StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a - 1L, this.g.b - 1 + par3Random.nextInt(3), this.g.c, this.h, i);
            } else if (j == 2) {
               StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a, this.g.b - 1 + par3Random.nextInt(3), this.g.c - 1L, 2, i);
            } else {
               StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a, this.g.b - 1 + par3Random.nextInt(3), this.g.f + 1L, 0, i);
            }
            break;
         case 2:
            if (j <= 1) {
               StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a, this.g.b - 1 + par3Random.nextInt(3), this.g.c - 1L, this.h, i);
            } else if (j == 2) {
               StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a - 1L, this.g.b - 1 + par3Random.nextInt(3), this.g.c, 1, i);
            } else {
               StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.d + 1L, this.g.b - 1 + par3Random.nextInt(3), this.g.c, 3, i);
            }
            break;
         case 3:
            if (j <= 1) {
               StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.d + 1L, this.g.b - 1 + par3Random.nextInt(3), this.g.c, this.h, i);
            } else if (j == 2) {
               StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.d - 3L, this.g.b - 1 + par3Random.nextInt(3), this.g.c - 1L, 2, i);
            } else {
               StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.d - 3L, this.g.b - 1 + par3Random.nextInt(3), this.g.f + 1L, 0, i);
            }
      }

      if (i < 8) {
         if (this.h != 2 && this.h != 0) {
            for (long l = this.g.a + 3L; l > this.g.a && l + 3L <= this.g.d; l += 5L) {
               int j1 = par3Random.nextInt(5);
               if (j1 == 0) {
                  StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, l, this.g.b, this.g.c - 1L, 2, i + 1);
               } else if (j1 == 1) {
                  StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, l, this.g.b, this.g.f + 1L, 0, i + 1);
               }
            }
         } else {
            for (long k = this.g.c + 3L; k > this.g.c && k + 3L <= this.g.f; k += 5L) {
               int i1 = par3Random.nextInt(5);
               if (i1 == 0) {
                  StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a - 1L, this.g.b, k, 1, i + 1);
               } else if (i1 == 1) {
                  StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.d + 1L, this.g.b, k, 3, i + 1);
               }
            }
         }
      }
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.a(par1World, par3StructureBoundingBox)) {
         return false;
      }

      int i = this.d * 5 - 1;
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 2L, 1, i, 0, 0, false);
      this.randomlyFillWithBlocks(par1World, par3StructureBoundingBox, par2Random, 0.8F, 0L, 2, 0L, 2L, 2, i, 0, 0, false);
      if (this.b) {
         this.randomlyFillWithBlocks(par1World, par3StructureBoundingBox, par2Random, 0.6F, 0L, 0, 0L, 2L, 1, i, Block.W.bO, 0, false);
      }

      for (int j = 0; j < this.d; j++) {
         int i1 = 2 + j * 5;
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 0, i1, 0L, 1, i1, Block.aZ.bO, 0, false);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 0, i1, 2L, 1, i1, Block.aZ.bO, 0, false);
         if (par2Random.nextInt(4) != 0) {
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, i1, 2L, 2, i1, Block.x.bO, 0, false);
         } else {
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, i1, 0L, 2, i1, Block.x.bO, 0, false);
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 2, i1, 2L, 2, i1, Block.x.bO, 0, false);
         }

         this.randomlyPlaceBlock(par1World, par3StructureBoundingBox, par2Random, 0.1F, 0L, 2, i1 - 1, Block.W.bO, 0);
         this.randomlyPlaceBlock(par1World, par3StructureBoundingBox, par2Random, 0.1F, 2L, 2, i1 - 1, Block.W.bO, 0);
         this.randomlyPlaceBlock(par1World, par3StructureBoundingBox, par2Random, 0.1F, 0L, 2, i1 + 1, Block.W.bO, 0);
         this.randomlyPlaceBlock(par1World, par3StructureBoundingBox, par2Random, 0.1F, 2L, 2, i1 + 1, Block.W.bO, 0);
         this.randomlyPlaceBlock(par1World, par3StructureBoundingBox, par2Random, 0.05F, 0L, 2, i1 - 2, Block.W.bO, 0);
         this.randomlyPlaceBlock(par1World, par3StructureBoundingBox, par2Random, 0.05F, 2L, 2, i1 - 2, Block.W.bO, 0);
         this.randomlyPlaceBlock(par1World, par3StructureBoundingBox, par2Random, 0.05F, 0L, 2, i1 + 2, Block.W.bO, 0);
         this.randomlyPlaceBlock(par1World, par3StructureBoundingBox, par2Random, 0.05F, 2L, 2, i1 + 2, Block.W.bO, 0);
         this.randomlyPlaceBlock(par1World, par3StructureBoundingBox, par2Random, 0.05F, 1L, 2, i1 - 1, Block.aq.bO, 0);
         this.randomlyPlaceBlock(par1World, par3StructureBoundingBox, par2Random, 0.05F, 1L, 2, i1 + 1, Block.aq.bO, 0);
         if (par2Random.nextInt(100) == 0) {
            this.createTreasureChestAtCurrentPosition(par1World, par3StructureBoundingBox, par2Random, 2L, 0, i1 - 1, StructureMineshaftPieces.a(), 3 + par2Random.nextInt(4));
         }

         if (par2Random.nextInt(100) == 0) {
            this.createTreasureChestAtCurrentPosition(par1World, par3StructureBoundingBox, par2Random, 0L, 0, i1 + 1, StructureMineshaftPieces.a(), 3 + par2Random.nextInt(4));
         }

         if (this.b && !this.c) {
            int l1 = this.b(0);
            long j2 = i1 - 1 + par2Random.nextInt(3);
            long k2 = this.getXWithOffset(1L, j2);
            j2 = this.getZWithOffset(1L, j2);
            if (par3StructureBoundingBox.isVecInside(k2, l1, j2)) {
               this.c = true;
               par1World.setBlockWithNotify(k2, l1, j2, Block.as.bO);
               TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)par1World.getBlockTileEntity(k2, l1, j2);
               if (tileentitymobspawner != null) {
                  tileentitymobspawner.a("CaveSpider");
               }
            }
         }
      }

      for (long k = 0L; k <= 2L; k++) {
         for (long j1 = 0L; j1 <= i; j1++) {
            int i2 = this.getBlockIdAtCurrentPosition(par1World, k, -1, j1, par3StructureBoundingBox);
            if (i2 == 0) {
               this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, k, -1, j1, par3StructureBoundingBox);
            }
         }
      }

      if (this.a) {
         for (long l = 0L; l <= i; l++) {
            int k1 = this.getBlockIdAtCurrentPosition(par1World, 1L, -1, l, par3StructureBoundingBox);
            if (k1 > 0 && Block.n[k1]) {
               this.randomlyPlaceBlock(par1World, par3StructureBoundingBox, par2Random, 0.7F, 1L, 0, l, Block.aG.bO, this.c(Block.aG.bO, 0));
            }
         }
      }

      return true;
   }
}
