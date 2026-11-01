import java.util.Random;

public class BlockBed extends w {
   public static final int[][] a = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

   public BlockBed(int par1) {
      super(par1, 134, acn.m);
      this.v();
   }

   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      if (par1World.F) {
         return true;
      }

      int i = par1World.getBlockMetadata(par2, par3, par4);
      if (!e(i)) {
         int j = a(i);
         par2 += a[j][0];
         par4 += a[j][1];
         if (par1World.getBlockId(par2, par3, par4) != this.bO) {
            return true;
         }

         i = par1World.getBlockMetadata(par2, par3, par4);
      }

      if (!par1World.t.d()) {
         double d = par2 + 0.5;
         double d1 = par3 + 0.5;
         double d2 = par4 + 0.5;
         par1World.setBlockWithNotify(par2, par3, par4, 0);
         int k = a(i);
         par2 += a[k][0];
         par4 += a[k][1];
         if (par1World.getBlockId(par2, par3, par4) == this.bO) {
            par1World.setBlockWithNotify(par2, par3, par4, 0);
            d = (d + par2 + 0.5) / 2.0;
            d1 = (d1 + par3 + 0.5) / 2.0;
            d2 = (d2 + par4 + 0.5) / 2.0;
         }

         par1World.a(null, (float)par2 + 0.5F, par3 + 0.5F, (float)par4 + 0.5F, 5.0F, true);
         return true;
      } else {
         if (h(i)) {
            EntityPlayer entityplayer = null;

            for (EntityPlayer entityplayer1 : par1World.d) {
               if (entityplayer1.TileEntityDispenser()) {
                  ChunkCoordinates chunkcoordinates = entityplayer1.aL;
                  if (chunkcoordinates.a == par2 && chunkcoordinates.b == par3 && chunkcoordinates.c == par4) {
                     entityplayer = entityplayer1;
                  }
               }
            }

            if (entityplayer != null) {
               par5EntityPlayer.b("tile.bed.occupied");
               return true;
            }

            setBedOccupied(par1World, par2, par3, par4, false);
         }

         ci enumstatus = par5EntityPlayer.sleepInBedAt(par2, par3, par4);
         if (enumstatus == ci.a) {
            setBedOccupied(par1World, par2, par3, par4, true);
            return true;
         }

         if (enumstatus == ci.c) {
            par5EntityPlayer.b("tile.bed.noSleep");
         } else if (enumstatus == ci.f) {
            par5EntityPlayer.b("tile.bed.notSafe");
         }

         return true;
      }
   }

   public int a(int par1, int par2) {
      if (par1 == 0) {
         return Block.x.bN;
      }

      int i = a(par2);
      int j = aav.h[i][par1];
      if (e(par2)) {
         if (j == 2) {
            return this.bN + 2 + 16;
         } else {
            return j != 5 && j != 4 ? this.bN + 1 : this.bN + 1 + 16;
         }
      } else if (j == 3) {
         return this.bN - 1 + 16;
      } else {
         return j != 5 && j != 4 ? this.bN : this.bN + 16;
      }
   }

   public int d() {
      return 14;
   }

   public boolean b() {
      return false;
   }

   public boolean a() {
      return false;
   }

   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      this.v();
   }

   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      int j = a(i);
      if (e(i)) {
         if (par1World.getBlockId(par2 - a[j][0], par3, par4 - a[j][1]) != this.bO) {
            par1World.setBlockWithNotify(par2, par3, par4, 0);
         }
      } else if (par1World.getBlockId(par2 + a[j][0], par3, par4 + a[j][1]) != this.bO) {
         par1World.setBlockWithNotify(par2, par3, par4, 0);
         if (!par1World.F) {
            this.dropBlockAsItem(par1World, par2, par3, par4, i, 0);
         }
      }
   }

   public int a(int par1, Random par2Random, int par3) {
      return e(par1) ? 0 : Item.ba.bQ;
   }

   private void v() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
   }

   public static boolean e(int par0) {
      return (par0 & 8) != 0;
   }

   public static boolean h(int par0) {
      return (par0 & 4) != 0;
   }

   public static void setBedOccupied(World par0World, long par1, int par2, long par3, boolean par4) {
      int i = par0World.getBlockMetadata(par1, par2, par3);
      if (par4) {
         i |= 4;
      } else {
         i &= -5;
      }

      par0World.setBlockMetadataWithNotify(par1, par2, par3, i);
   }

   public static ChunkCoordinates getNearestEmptyChunkCoordinates(World par0World, long par1, int par2, long par3, int par4) {
      int i = par0World.getBlockMetadata(par1, par2, par3);
      int j = w.a(i);

      for (int k = 0; k <= 1; k++) {
         long l = par1 - a[j][0] * k - 1L;
         long i1 = par3 - a[j][1] * k - 1L;
         long j1 = l + 2L;
         long k1 = i1 + 2L;

         for (long l1 = l; l1 <= j1; l1++) {
            for (long i2 = i1; i2 <= k1; i2++) {
               if (par0World.isBlockNormalCube(l1, par2 - 1, i2) && par0World.isAirBlock(l1, par2, i2) && par0World.isAirBlock(l1, par2 + 1, i2)) {
                  if (par4 <= 0) {
                     return new ChunkCoordinates(l1, par2, i2);
                  }

                  par4--;
               }
            }
         }
      }

      return null;
   }

   public void dropBlockAsItemWithChance(World par1World, long par2, int par3, long par4, int par5, float par6, int par7) {
      if (!e(par5)) {
         super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, 0);
      }
   }

   public int f() {
      return 1;
   }
}
