import java.util.Random;

public abstract class BlockFluid extends Block {
   protected BlockFluid(int par1, acn par2Material) {
      super(par1, (par2Material != acn.h ? 12 : 14) * 16 + 13, par2Material);
      float f = 0.0F;
      float f1 = 0.0F;
      this.a(0.0F + f1, 0.0F + f, 0.0F + f1, 1.0F + f1, 1.0F + f, 1.0F + f1);
      this.a(true);
   }

   @Override
   public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      return this.cd != acn.h;
   }

   @Override
   public int i() {
      return 16777215;
   }

   @Override
   public int colorMultiplier(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      if (this.cd != acn.g) {
         return 16777215;
      }

      int i = 0;
      int j = 0;
      int k = 0;

      for (int l = -1; l <= 1; l++) {
         for (int i1 = -1; i1 <= 1; i1++) {
            int j1 = par1IBlockAccess.getBiomeGenForCoords(par2 + i1, par4 + l).H;
            i += (j1 & 0xFF0000) >> 16;
            j += (j1 & 0xFF00) >> 8;
            k += j1 & 0xFF;
         }
      }

      return (i / 9 & 0xFF) << 16 | (j / 9 & 0xFF) << 8 | k / 9 & 0xFF;
   }

   public static float e(int par0) {
      if (par0 >= 8) {
         par0 = 0;
      }

      return (par0 + 1) / 9.0F;
   }

   @Override
   public int a_(int par1) {
      return par1 != 0 && par1 != 1 ? this.bN + 1 : this.bN;
   }

   protected int getFlowDecay(World par1World, long par2, int par3, long par4) {
      return par1World.getBlockMaterial(par2, par3, par4) != this.cd ? -1 : par1World.getBlockMetadata(par2, par3, par4);
   }

   protected int getEffectiveFlowDecay(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      if (par1IBlockAccess.getBlockMaterial(par2, par3, par4) != this.cd) {
         return -1;
      }

      int i = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
      if (i >= 8) {
         i = 0;
      }

      return i;
   }

   @Override
   public boolean b() {
      return false;
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public boolean a(int par1, boolean par2) {
      return par2 && par1 == 0;
   }

   @Override
   public boolean isBlockSolid(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      acn material = par1IBlockAccess.getBlockMaterial(par2, par3, par4);
      if (material == this.cd) {
         return false;
      } else if (par5 == 1) {
         return true;
      } else {
         return material == acn.u ? false : super.isBlockSolid(par1IBlockAccess, par2, par3, par4, par5);
      }
   }

   @Override
   public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      acn material = par1IBlockAccess.getBlockMaterial(par2, par3, par4);
      if (material == this.cd) {
         return false;
      } else if (par5 == 1) {
         return true;
      } else {
         return material == acn.u ? false : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
      }
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long i) {
      return null;
   }

   @Override
   public int d() {
      return 4;
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return 0;
   }

   @Override
   public int a(Random par1Random) {
      return 0;
   }

   private bo getFlowVector(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      bo vec3d = bo.b(0.0, 0.0, 0.0);
      int i = this.getEffectiveFlowDecay(par1IBlockAccess, par2, par3, par4);

      for (int j = 0; j < 4; j++) {
         long k = par2;
         int l = par3;
         long i1 = par4;
         if (j == 0) {
            k--;
         }

         if (j == 1) {
            i1--;
         }

         if (j == 2) {
            k++;
         }

         if (j == 3) {
            i1++;
         }

         int j1 = this.getEffectiveFlowDecay(par1IBlockAccess, k, l, i1);
         if (j1 < 0) {
            if (!par1IBlockAccess.getBlockMaterial(k, l, i1).c()) {
               j1 = this.getEffectiveFlowDecay(par1IBlockAccess, k, l - 1, i1);
               if (j1 >= 0) {
                  int k1 = j1 - (i - 8);
                  vec3d = vec3d.c((k - par2) * k1, (l - par3) * k1, (i1 - par4) * k1);
               }
            }
         } else if (j1 >= 0) {
            int l1 = j1 - i;
            vec3d = vec3d.c((k - par2) * l1, (l - par3) * l1, (i1 - par4) * l1);
         }
      }

      if (par1IBlockAccess.getBlockMetadata(par2, par3, par4) >= 8) {
         boolean flag = false;
         if (flag || this.isBlockSolid(par1IBlockAccess, par2, par3, par4 - 1L, 2)) {
            flag = true;
         }

         if (flag || this.isBlockSolid(par1IBlockAccess, par2, par3, par4 + 1L, 3)) {
            flag = true;
         }

         if (flag || this.isBlockSolid(par1IBlockAccess, par2 - 1L, par3, par4, 4)) {
            flag = true;
         }

         if (flag || this.isBlockSolid(par1IBlockAccess, par2 + 1L, par3, par4, 5)) {
            flag = true;
         }

         if (flag || this.isBlockSolid(par1IBlockAccess, par2, par3 + 1, par4 - 1L, 2)) {
            flag = true;
         }

         if (flag || this.isBlockSolid(par1IBlockAccess, par2, par3 + 1, par4 + 1L, 3)) {
            flag = true;
         }

         if (flag || this.isBlockSolid(par1IBlockAccess, par2 - 1L, par3 + 1, par4, 4)) {
            flag = true;
         }

         if (flag || this.isBlockSolid(par1IBlockAccess, par2 + 1L, par3 + 1, par4, 5)) {
            flag = true;
         }

         if (flag) {
            vec3d = vec3d.c().c(0.0, -6.0, 0.0);
         }
      }

      return vec3d.c();
   }

   @Override
   public void velocityToAddToEntity(World par1World, long par2, int par3, long par4, Entity par5Entity, bo par6Vec3D) {
      bo vec3d = this.getFlowVector(par1World, par2, par3, par4);
      par6Vec3D.a = par6Vec3D.a + vec3d.a;
      par6Vec3D.b = par6Vec3D.b + vec3d.b;
      par6Vec3D.c = par6Vec3D.c + vec3d.c;
   }

   @Override
   public int e() {
      if (this.cd == acn.g) {
         return 5;
      } else {
         return this.cd != acn.h ? 0 : 30;
      }
   }

   @Override
   public int getMixedBrightnessForBlock(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      int i = par1IBlockAccess.getLightBrightnessForSkyBlocks(par2, par3, par4, 0);
      int j = par1IBlockAccess.getLightBrightnessForSkyBlocks(par2, par3 + 1, par4, 0);
      int k = i & 0xFF;
      int l = j & 0xFF;
      int i1 = i >> 16 & 0xFF;
      int j1 = j >> 16 & 0xFF;
      return (k <= l ? l : k) | (i1 <= j1 ? j1 : i1) << 16;
   }

   @Override
   public float getBlockBrightness(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      float f = par1IBlockAccess.getLightBrightness(par2, par3, par4);
      float f1 = par1IBlockAccess.getLightBrightness(par2, par3 + 1, par4);
      return f <= f1 ? f1 : f;
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      super.updateTick(par1World, par2, par3, par4, par5Random);
   }

   @Override
   public int c() {
      return this.cd != acn.g ? 0 : 1;
   }

   @Override
   public void randomDisplayTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (this.cd == acn.g) {
         if (par5Random.nextInt(10) == 0) {
            int i = par1World.getBlockMetadata(par2, par3, par4);
            if (i <= 0 || i >= 8) {
               par1World.a(
                  "suspended",
                  (double)par2 + par5Random.nextFloat(),
                  (double)par3 + par5Random.nextFloat(),
                  (double)par4 + par5Random.nextFloat(),
                  0.0,
                  0.0,
                  0.0
               );
            }
         }

         for (int j = 0; j < 0; j++) {
            int l = par5Random.nextInt(4);
            long i1 = par2;
            long j1 = par4;
            if (l == 0) {
               i1--;
            }

            if (l == 1) {
               i1++;
            }

            if (l == 2) {
               j1--;
            }

            if (l == 3) {
               j1++;
            }

            if (par1World.getBlockMaterial(i1, par3, j1) == acn.a
               && (par1World.getBlockMaterial(i1, par3 - 1, j1).c() || par1World.getBlockMaterial(i1, par3 - 1, j1).d())) {
               double f = 0.0625;
               double d6 = (double)par2 + par5Random.nextFloat();
               double d7 = (double)par3 + par5Random.nextFloat();
               double d8 = (double)par4 + par5Random.nextFloat();
               if (l == 0) {
                  d6 = par2 - f;
               }

               if (l == 1) {
                  d6 = par2 + 1L + f;
               }

               if (l == 2) {
                  d8 = par4 - f;
               }

               if (l == 3) {
                  d8 = par4 + 1L + f;
               }

               double d9 = 0.0;
               double d10 = 0.0;
               if (l == 0) {
                  d9 = -f;
               }

               if (l == 1) {
                  d9 = f;
               }

               if (l == 2) {
                  d10 = -f;
               }

               if (l == 3) {
                  d10 = f;
               }

               par1World.a("splash", d6, d7, d8, d9, 0.0, d10);
            }
         }
      }

      if (this.cd == acn.g && par5Random.nextInt(64) == 0) {
         int k = par1World.getBlockMetadata(par2, par3, par4);
         if (k > 0 && k < 8) {
            par1World.a(
               (float)par2 + 0.5F,
               par3 + 0.5F,
               (float)par4 + 0.5F,
               "liquid.water",
               par5Random.nextFloat() * 0.25F + 0.75F,
               par5Random.nextFloat() * 1.0F + 0.5F
            );
         }
      }

      if (this.cd == acn.h && par1World.getBlockMaterial(par2, par3 + 1, par4) == acn.a && !par1World.isBlockOpaqueCube(par2, par3 + 1, par4)) {
         if (par5Random.nextInt(100) == 0) {
            double d = (double)par2 + par5Random.nextFloat();
            double d2 = par3 + this.bZ;
            double d4 = (double)par4 + par5Random.nextFloat();
            par1World.a("lava", d, d2, d4, 0.0, 0.0, 0.0);
            par1World.a(d, d2, d4, "liquid.lavapop", 0.2F + par5Random.nextFloat() * 0.2F, 0.9F + par5Random.nextFloat() * 0.15F);
         }

         if (par5Random.nextInt(200) == 0) {
            par1World.a(par2, par3, par4, "liquid.lava", 0.2F + par5Random.nextFloat() * 0.2F, 0.9F + par5Random.nextFloat() * 0.15F);
         }
      }

      if (par5Random.nextInt(10) == 0 && par1World.isBlockNormalCube(par2, par3 - 1, par4) && !par1World.getBlockMaterial(par2, par3 - 2, par4).c()) {
         double d1 = (double)par2 + par5Random.nextFloat();
         double d3 = par3 - 1.05;
         double d5 = (double)par4 + par5Random.nextFloat();
         if (this.cd == acn.g) {
            par1World.a("dripWater", d1, d3, d5, 0.0, 0.0, 0.0);
         } else {
            par1World.a("dripLava", d1, d3, d5, 0.0, 0.0, 0.0);
         }
      }
   }

   public static double func_293_a(IBlockAccess par0IBlockAccess, long par1, int par2, long par3, acn par4Material) {
      bo vec3d = null;
      if (par4Material == acn.g) {
         vec3d = ((BlockFluid)Block.A).getFlowVector(par0IBlockAccess, par1, par2, par3);
      }

      if (par4Material == acn.h) {
         vec3d = ((BlockFluid)Block.C).getFlowVector(par0IBlockAccess, par1, par2, par3);
      }

      return vec3d.a == 0.0 && vec3d.c == 0.0 ? -1000.0 : Math.atan2(vec3d.c, vec3d.a) - (Math.PI / 2);
   }

   @Override
   public void onBlockAdded(World par1World, long par2, int par3, long par4) {
      this.checkForHarden(par1World, par2, par3, par4);
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      this.checkForHarden(par1World, par2, par3, par4);
   }

   private void checkForHarden(World par1World, long par2, int par3, long par4) {
      if (par1World.getBlockId(par2, par3, par4) == this.bO) {
         if (this.cd == acn.h) {
            boolean flag = false;
            if (flag || par1World.getBlockMaterial(par2, par3, par4 - 1L) == acn.g) {
               flag = true;
            }

            if (flag || par1World.getBlockMaterial(par2, par3, par4 + 1L) == acn.g) {
               flag = true;
            }

            if (flag || par1World.getBlockMaterial(par2 - 1L, par3, par4) == acn.g) {
               flag = true;
            }

            if (flag || par1World.getBlockMaterial(par2 + 1L, par3, par4) == acn.g) {
               flag = true;
            }

            if (flag || par1World.getBlockMaterial(par2, par3 + 1, par4) == acn.g) {
               flag = true;
            }

            if (flag) {
               int i = par1World.getBlockMetadata(par2, par3, par4);
               if (i == 0) {
                  par1World.setBlockWithNotify(par2, par3, par4, Block.ap.bO);
               } else if (i <= 4) {
                  par1World.setBlockWithNotify(par2, par3, par4, Block.w.bO);
               }

               this.triggerLavaMixEffects(par1World, par2, par3, par4);
            }
         }
      }
   }

   protected void triggerLavaMixEffects(World par1World, long par2, int par3, long par4) {
      par1World.a(par2 + 0.5, par3 + 0.5, par4 + 0.5, "random.fizz", 0.5F, 2.6F + (par1World.r.nextFloat() - par1World.r.nextFloat()) * 0.8F);

      for (int i = 0; i < 8; i++) {
         par1World.a("largesmoke", par2 + Math.random(), par3 + 1.2, par4 + Math.random(), 0.0, 0.0, 0.0);
      }
   }
}
