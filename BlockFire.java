import java.util.Random;

public class BlockFire extends Block {
   private int[] a = new int[256];
   private int[] b = new int[256];

   protected BlockFire(int par1, int par2) {
      super(par1, par2, acn.n);
      this.a(true);
   }

   @Override
   public void l() {
      this.a(Block.x.bO, 5, 20);
      this.a(Block.aZ.bO, 5, 20);
      this.a(Block.at.bO, 5, 20);
      this.a(Block.J.bO, 5, 5);
      this.a(Block.K.bO, 30, 60);
      this.a(Block.MapGenVillage.bO, 30, 20);
      this.a(Block.NoiseGeneratorPerlin.bO, 15, 100);
      this.a(Block.X.bO, 60, 100);
      this.a(Block.ab.bO, 30, 60);
      this.a(Block.bu.bO, 15, 100);
   }

   private void a(int par1, int par2, int par3) {
      this.a[par1] = par2;
      this.b[par1] = par3;
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long i) {
      return null;
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public boolean b() {
      return false;
   }

   @Override
   public int d() {
      return 3;
   }

   @Override
   public int a(Random par1Random) {
      return 0;
   }

   @Override
   public int e() {
      return 30;
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      boolean flag = par1World.getBlockId(par2, par3 - 1, par4) == Block.ItemBucket.bO;
      if (par1World.t instanceof WorldProviderEnd && par1World.getBlockId(par2, par3 - 1, par4) == Block.z.bO) {
         flag = true;
      }

      if (!this.canPlaceBlockAt(par1World, par2, par3, par4)) {
         par1World.setBlockWithNotify(par2, par3, par4, 0);
      }

      if (flag
         || !par1World.G()
         || !par1World.canLightningStrikeAt(par2, par3, par4)
            && !par1World.canLightningStrikeAt(par2 - 1L, par3, par4)
            && !par1World.canLightningStrikeAt(par2 + 1L, par3, par4)
            && !par1World.canLightningStrikeAt(par2, par3, par4 - 1L)
            && !par1World.canLightningStrikeAt(par2, par3, par4 + 1L)) {
         int i = par1World.getBlockMetadata(par2, par3, par4);
         if (i < 15) {
            par1World.setBlockMetadata(par2, par3, par4, i + par5Random.nextInt(3) / 2);
         }

         par1World.scheduleBlockUpdate(par2, par3, par4, this.bO, this.e() + par5Random.nextInt(10));
         if (!flag && !this.canNeighborBurn(par1World, par2, par3, par4)) {
            if (!par1World.isBlockNormalCube(par2, par3 - 1, par4) || i > 3) {
               par1World.setBlockWithNotify(par2, par3, par4, 0);
            }
         } else if (!flag && !this.canBlockCatchFire(par1World, par2, par3 - 1, par4) && i == 15 && par5Random.nextInt(4) == 0) {
            par1World.setBlockWithNotify(par2, par3, par4, 0);
         } else {
            boolean flag1 = par1World.isBlockHighHumidity(par2, par3, par4);
            byte byte0 = 0;
            if (flag1) {
               byte0 = -50;
            }

            this.tryToCatchBlockOnFire(par1World, par2 + 1L, par3, par4, 300 + byte0, par5Random, i);
            this.tryToCatchBlockOnFire(par1World, par2 - 1L, par3, par4, 300 + byte0, par5Random, i);
            this.tryToCatchBlockOnFire(par1World, par2, par3 - 1, par4, 250 + byte0, par5Random, i);
            this.tryToCatchBlockOnFire(par1World, par2, par3 + 1, par4, 250 + byte0, par5Random, i);
            this.tryToCatchBlockOnFire(par1World, par2, par3, par4 - 1L, 300 + byte0, par5Random, i);
            this.tryToCatchBlockOnFire(par1World, par2, par3, par4 + 1L, 300 + byte0, par5Random, i);

            for (long j = par2 - 1L; j <= par2 + 1L; j++) {
               for (long k = par4 - 1L; k <= par4 + 1L; k++) {
                  for (int l = par3 - 1; l <= par3 + 4; l++) {
                     if (j != par2 || l != par3 || k != par4) {
                        int i1 = 100;
                        if (l > par3 + 1) {
                           i1 += (l - (par3 + 1)) * 100;
                        }

                        int j1 = this.getChanceOfNeighborsEncouragingFire(par1World, j, l, k);
                        if (j1 > 0) {
                           int k1 = (j1 + 40) / (i + 30);
                           if (flag1) {
                              k1 /= 2;
                           }

                           if (k1 > 0
                              && par5Random.nextInt(i1) <= k1
                              && (!par1World.G() || !par1World.canLightningStrikeAt(j, l, k))
                              && !par1World.canLightningStrikeAt(j - 1L, l, par4)
                              && !par1World.canLightningStrikeAt(j + 1L, l, k)
                              && !par1World.canLightningStrikeAt(j, l, k - 1L)
                              && !par1World.canLightningStrikeAt(j, l, k + 1L)) {
                              int l1 = i + par5Random.nextInt(5) / 4;
                              if (l1 > 15) {
                                 l1 = 15;
                              }

                              par1World.setBlockAndMetadataWithNotify(j, l, k, this.bO, l1);
                           }
                        }
                     }
                  }
               }
            }
         }
      } else {
         par1World.setBlockWithNotify(par2, par3, par4, 0);
      }
   }

   private void tryToCatchBlockOnFire(World par1World, long par2, int par3, long par4, int par5, Random par6Random, int par7) {
      int i = this.b[par1World.getBlockId(par2, par3, par4)];
      if (par6Random.nextInt(par5) < i) {
         boolean flag = par1World.getBlockId(par2, par3, par4) == Block.NoiseGeneratorPerlin.bO;
         if (par6Random.nextInt(par7 + 10) < 5 && !par1World.canLightningStrikeAt(par2, par3, par4)) {
            int j = par7 + par6Random.nextInt(5) / 4;
            if (j > 15) {
               j = 15;
            }

            par1World.setBlockAndMetadataWithNotify(par2, par3, par4, this.bO, j);
         } else {
            par1World.setBlockWithNotify(par2, par3, par4, 0);
         }

         if (flag) {
            Block.NoiseGeneratorPerlin.onBlockDestroyedByPlayer(par1World, par2, par3, par4, 1);
         }
      }
   }

   private boolean canNeighborBurn(World par1World, long par2, int par3, long par4) {
      if (this.canBlockCatchFire(par1World, par2 + 1L, par3, par4)) {
         return true;
      } else if (this.canBlockCatchFire(par1World, par2 - 1L, par3, par4)) {
         return true;
      } else if (this.canBlockCatchFire(par1World, par2, par3 - 1, par4)) {
         return true;
      } else if (this.canBlockCatchFire(par1World, par2, par3 + 1, par4)) {
         return true;
      } else {
         return this.canBlockCatchFire(par1World, par2, par3, par4 - 1L) ? true : this.canBlockCatchFire(par1World, par2, par3, par4 + 1L);
      }
   }

   private int getChanceOfNeighborsEncouragingFire(World par1World, long par2, int par3, long par4) {
      int i = 0;
      if (!par1World.isAirBlock(par2, par3, par4)) {
         return 0;
      }

      i = this.getChanceToEncourageFire(par1World, par2 + 1L, par3, par4, i);
      i = this.getChanceToEncourageFire(par1World, par2 - 1L, par3, par4, i);
      i = this.getChanceToEncourageFire(par1World, par2, par3 - 1, par4, i);
      i = this.getChanceToEncourageFire(par1World, par2, par3 + 1, par4, i);
      i = this.getChanceToEncourageFire(par1World, par2, par3, par4 - 1L, i);
      return this.getChanceToEncourageFire(par1World, par2, par3, par4 + 1L, i);
   }

   @Override
   public boolean j() {
      return false;
   }

   public boolean canBlockCatchFire(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      return this.a[par1IBlockAccess.getBlockId(par2, par3, par4)] > 0;
   }

   public int getChanceToEncourageFire(World par1World, long par2, int par3, long par4, int par5) {
      int i = this.a[par1World.getBlockId(par2, par3, par4)];
      return i > par5 ? i : par5;
   }

   @Override
   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      return par1World.isBlockNormalCube(par2, par3 - 1, par4) || this.canNeighborBurn(par1World, par2, par3, par4);
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      if (!par1World.isBlockNormalCube(par2, par3 - 1, par4) && !this.canNeighborBurn(par1World, par2, par3, par4)) {
         par1World.setBlockWithNotify(par2, par3, par4, 0);
      }
   }

   @Override
   public void onBlockAdded(World par1World, long par2, int par3, long par4) {
      if (par1World.t.g > 0 || par1World.getBlockId(par2, par3 - 1, par4) != Block.ap.bO || !Block.be.tryToCreatePortal(par1World, par2, par3, par4)) {
         if (!par1World.isBlockNormalCube(par2, par3 - 1, par4) && !this.canNeighborBurn(par1World, par2, par3, par4)) {
            par1World.setBlockWithNotify(par2, par3, par4, 0);
         } else {
            par1World.scheduleBlockUpdate(par2, par3, par4, this.bO, this.e() + par1World.r.nextInt(10));
         }
      }
   }

   @Override
   public void randomDisplayTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (par5Random.nextInt(24) == 0) {
         par1World.a(par2 + 0.5, par3 + 0.5, par4 + 0.5, "fire.fire", 1.0F + par5Random.nextFloat(), par5Random.nextFloat() * 0.7F + 0.3F);
      }

      if (!par1World.isBlockNormalCube(par2, par3 - 1, par4) && !Block.ar.canBlockCatchFire(par1World, par2, par3 - 1, par4)) {
         if (Block.ar.canBlockCatchFire(par1World, par2 - 1L, par3, par4)) {
            for (int j = 0; j < 2; j++) {
               double f1 = (double)par2 + par5Random.nextFloat() * 0.1F;
               double f7 = (double)par3 + par5Random.nextFloat();
               double f13 = (double)par4 + par5Random.nextFloat();
               par1World.a("largesmoke", f1, f7, f13, 0.0, 0.0, 0.0);
            }
         }

         if (Block.ar.canBlockCatchFire(par1World, par2 + 1L, par3, par4)) {
            for (int k = 0; k < 2; k++) {
               double f2 = (double)(par2 + 1L) - par5Random.nextFloat() * 0.1F;
               double f8 = (double)par3 + par5Random.nextFloat();
               double f14 = (double)par4 + par5Random.nextFloat();
               par1World.a("largesmoke", f2, f8, f14, 0.0, 0.0, 0.0);
            }
         }

         if (Block.ar.canBlockCatchFire(par1World, par2, par3, par4 - 1L)) {
            for (int l = 0; l < 2; l++) {
               double f3 = (double)par2 + par5Random.nextFloat();
               double f9 = (double)par3 + par5Random.nextFloat();
               double f15 = (double)par4 + par5Random.nextFloat() * 0.1F;
               par1World.a("largesmoke", f3, f9, f15, 0.0, 0.0, 0.0);
            }
         }

         if (Block.ar.canBlockCatchFire(par1World, par2, par3, par4 + 1L)) {
            for (int i1 = 0; i1 < 2; i1++) {
               double f4 = (double)par2 + par5Random.nextFloat();
               double f10 = (double)par3 + par5Random.nextFloat();
               double f16 = (double)(par4 + 1L) - par5Random.nextFloat() * 0.1F;
               par1World.a("largesmoke", f4, f10, f16, 0.0, 0.0, 0.0);
            }
         }

         if (Block.ar.canBlockCatchFire(par1World, par2, par3 + 1, par4)) {
            for (int j1 = 0; j1 < 2; j1++) {
               double f5 = (double)par2 + par5Random.nextFloat();
               double f11 = (double)(par3 + 1) - par5Random.nextFloat() * 0.1F;
               double f17 = (double)par4 + par5Random.nextFloat();
               par1World.a("largesmoke", f5, f11, f17, 0.0, 0.0, 0.0);
            }
         }
      } else {
         for (int i = 0; i < 3; i++) {
            double f = (double)par2 + par5Random.nextFloat();
            double f6 = (double)par3 + (par5Random.nextFloat() * 0.5F + 0.5F);
            double f12 = (double)par4 + par5Random.nextFloat();
            par1World.a("largesmoke", f, f6, f12, 0.0, 0.0, 0.0);
         }
      }
   }
}
