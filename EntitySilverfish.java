public class EntitySilverfish extends EntityMob {
   private int a;

   public EntitySilverfish(World par1World) {
      super(par1World);
      this.bm = "/mob/silverfish.png";
      this.a(0.3F, 0.7F);
      this.TileEntityMobSpawner = 0.6F;
      this.c = 1;
   }

   @Override
   public int d() {
      return 8;
   }

   @Override
   protected boolean e_() {
      return false;
   }

   @Override
   protected Entity h() {
      double d = 8.0;
      return this.k.b(this, d);
   }

   @Override
   protected String m() {
      return "mob.silverfish.say";
   }

   @Override
   protected String n() {
      return "mob.silverfish.hit";
   }

   @Override
   protected String o() {
      return "mob.silverfish.kill";
   }

   @Override
   public boolean a(md par1DamageSource, int par2) {
      if (this.a <= 0 && par1DamageSource instanceof fl) {
         this.a = 20;
      }

      return super.a(par1DamageSource, par2);
   }

   @Override
   protected void a(Entity par1Entity, float par2) {
      if (this.bE <= 0 && par2 < 1.2F && par1Entity.y.e > this.y.b && par1Entity.y.b < this.y.e) {
         this.bE = 20;
         par1Entity.a(md.a(this), this.c);
      }
   }

   @Override
   protected void playStepSound(long par1, int par2, long par3, int par4) {
      this.k.a(this, "mob.silverfish.step", 1.0F, 1.0F);
   }

   @Override
   public void b(ady par1NBTTagCompound) {
      super.b(par1NBTTagCompound);
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      super.a(par1NBTTagCompound);
   }

   @Override
   protected int f() {
      return 0;
   }

   @Override
   public void J_() {
      this.bd = this.u;
      super.J_();
   }

   @Override
   protected void y_() {
      super.y_();
      if (!this.k.F) {
         if (this.a > 0) {
            this.a--;
            if (this.a == 0) {
               long i = MathHelper.d(this.o);
               int k = MathHelper.c(this.p);
               long i1 = MathHelper.d(this.q);
               boolean flag = false;

               for (int l1 = 0; !flag && l1 <= 5 && l1 >= -5; l1 = l1 > 0 ? 0 - l1 : 1 - l1) {
                  for (int j2 = 0; !flag && j2 <= 10 && j2 >= -10; j2 = j2 > 0 ? 0 - j2 : 1 - j2) {
                     for (int k2 = 0; !flag && k2 <= 10 && k2 >= -10; k2 = k2 > 0 ? 0 - k2 : 1 - k2) {
                        int l2 = this.k.getBlockId(i + j2, k + l1, i1 + k2);
                        if (l2 == Block.bl.bO) {
                           this.k.playAuxSFX(2001, i + j2, k + l1, i1 + k2, Block.bl.bO + (this.k.getBlockMetadata(i + j2, k + l1, i1 + k2) << 12));
                           this.k.setBlockWithNotify(i + j2, k + l1, i1 + k2, 0);
                           Block.bl.onBlockDestroyedByPlayer(this.k, i + j2, k + l1, i1 + k2, 0);
                           if (this.U.nextBoolean()) {
                              flag = true;
                              break;
                           }
                        }
                     }
                  }
               }
            }
         }

         if (this.GenLayerHills == null && !this.ar()) {
            long j = MathHelper.d(this.o);
            int l = MathHelper.c(this.p + 0.5);
            long j1 = MathHelper.d(this.q);
            int k1 = this.U.nextInt(6);
            int i2 = this.k.getBlockId(j + qs.b[k1], l + qs.c[k1], j1 + qs.d[k1]);
            if (BlockSilverfish.e(i2)) {
               this.k.setBlockAndMetadataWithNotify(j + qs.b[k1], l + qs.c[k1], j1 + qs.d[k1], Block.bl.bO, BlockSilverfish.h(i2));
               this.ba();
               this.A();
            } else {
               this.ap();
            }
         } else if (this.GenLayerHills != null && !this.ar()) {
            this.GenLayerHills = null;
         }
      }
   }

   @Override
   public float getBlockPathWeight(long par1, int par2, long par3) {
      return this.k.getBlockId(par1, par2 - 1, par3) == Block.t.bO ? 10.0F : super.getBlockPathWeight(par1, par2, par3);
   }

   @Override
   protected boolean BlockSnowBlock() {
      return true;
   }

   @Override
   public boolean i() {
      if (super.i()) {
         EntityPlayer entityplayer = this.k.a(this, 5.0);
         return entityplayer == null;
      } else {
         return false;
      }
   }

   @Override
   public bk s() {
      return bk.c;
   }
}
