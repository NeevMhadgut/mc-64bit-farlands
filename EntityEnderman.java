public class EntityEnderman extends EntityMob {
   private static boolean[] b = new boolean[256];
   public boolean a = false;
   private int d = 0;
   private int e = 0;

   public EntityEnderman(World par1World) {
      super(par1World);
      this.bm = "/mob/enderman.png";
      this.TileEntityMobSpawner = 0.2F;
      this.c = 7;
      this.a(0.6F, 2.9F);
      this.R = 1.0F;
   }

   @Override
   public int d() {
      return 40;
   }

   @Override
   protected void b() {
      super.b();
      this.EntityNoteFX.a(16, new Byte((byte)0));
      this.EntityNoteFX.a(17, new Byte((byte)0));
   }

   @Override
   public void b(ady par1NBTTagCompound) {
      super.b(par1NBTTagCompound);
      par1NBTTagCompound.a("carried", (short)this.z_());
      par1NBTTagCompound.a("carriedData", (short)this.x());
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      super.a(par1NBTTagCompound);
      this.g_(par1NBTTagCompound.e("carried"));
      this.h_(par1NBTTagCompound.e("carriedData"));
   }

   @Override
   protected Entity h() {
      EntityPlayer entityplayer = this.k.b(this, 64.0);
      if (entityplayer != null) {
         if (this.d(entityplayer)) {
            if (this.e++ == 5) {
               this.e = 0;
               return entityplayer;
            }
         } else {
            this.e = 0;
         }
      }

      return null;
   }

   @Override
   public int b(float par1) {
      return super.b(par1);
   }

   @Override
   public float a(float par1) {
      return super.a(par1);
   }

   private boolean d(EntityPlayer par1EntityPlayer) {
      ItemStack itemstack = par1EntityPlayer.ap.b[3];
      if (itemstack != null && itemstack.c == Block.ba.bO) {
         return false;
      }

      bo vec3d = par1EntityPlayer.k(1.0F).c();
      bo vec3d1 = bo.b(this.o - par1EntityPlayer.o, this.y.b + this.J / 2.0F - (par1EntityPlayer.p + par1EntityPlayer.I()), this.q - par1EntityPlayer.q);
      double d = vec3d1.d();
      vec3d1 = vec3d1.c();
      double d1 = vec3d.b(vec3d1);
      return d1 > 1.0 - 0.025 / d ? par1EntityPlayer.m(this) : false;
   }

   @Override
   public void e() {
      if (this.G()) {
         this.a(md.f, 1);
      }

      this.a = this.GenLayerHills != null;
      this.TileEntityMobSpawner = this.GenLayerHills == null ? 0.3F : 6.5F;
      if (!this.k.F) {
         if (this.z_() == 0) {
            if (this.U.nextInt(20) == 0) {
               long i = MathHelper.d(this.o - 2.0 + this.U.nextDouble() * 4.0);
               int l = MathHelper.c(this.p + this.U.nextDouble() * 3.0);
               long j1 = MathHelper.d(this.q - 2.0 + this.U.nextDouble() * 4.0);
               int l1 = this.k.getBlockId(i, l, j1);
               if (b[l1]) {
                  this.g_(this.k.getBlockId(i, l, j1));
                  this.h_(this.k.getBlockMetadata(i, l, j1));
                  this.k.setBlockWithNotify(i, l, j1, 0);
               }
            }
         } else if (this.U.nextInt(2000) == 0) {
            long j = MathHelper.d(this.o - 1.0 + this.U.nextDouble() * 2.0);
            int i1 = MathHelper.c(this.p + this.U.nextDouble() * 2.0);
            long k1 = MathHelper.d(this.q - 1.0 + this.U.nextDouble() * 2.0);
            int i2 = this.k.getBlockId(j, i1, k1);
            int j2 = this.k.getBlockId(j, i1 - 1, k1);
            if (i2 == 0 && j2 > 0 && Block.m[j2].b()) {
               this.k.setBlockAndMetadataWithNotify(j, i1, k1, this.z_(), this.x());
               this.g_(0);
            }
         }
      }

      for (int k = 0; k < 2; k++) {
         this.k
            .a(
               "portal",
               this.o + (this.U.nextDouble() - 0.5) * this.I,
               this.p + this.U.nextDouble() * this.J - 0.25,
               this.q + (this.U.nextDouble() - 0.5) * this.I,
               (this.U.nextDouble() - 0.5) * 2.0,
               -this.U.nextDouble(),
               (this.U.nextDouble() - 0.5) * 2.0
            );
      }

      if (this.k.m() && !this.k.F) {
         float f = this.a(1.0F);
         if (f > 0.5F && this.k.canBlockSeeTheSky(MathHelper.d(this.o), MathHelper.c(this.p), MathHelper.d(this.q)) && this.U.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
            this.GenLayerHills = null;
            this.u();
         }
      }

      if (this.G()) {
         this.GenLayerHills = null;
         this.u();
      }

      this.ch = false;
      if (this.GenLayerHills != null) {
         this.a(this.GenLayerHills, 100.0F, 100.0F);
      }

      if (!this.k.F && this.M()) {
         if (this.GenLayerHills != null) {
            if (this.GenLayerHills instanceof EntityPlayer && this.d((EntityPlayer)this.GenLayerHills)) {
               this.ce = this.cf = 0.0F;
               this.TileEntityMobSpawner = 0.0F;
               if (this.GenLayerHills.f(this) < 16.0) {
                  this.u();
               }

               this.d = 0;
            } else if (this.GenLayerHills.f(this) > 256.0 && this.d++ >= 30 && this.d(this.GenLayerHills)) {
               this.d = 0;
            }
         } else {
            this.d = 0;
         }
      }

      super.e();
   }

   protected boolean u() {
      double d = this.o + (this.U.nextFloat() - 0.5F) * 64.0F;
      double d1 = this.p + (this.U.nextInt(64) - 32);
      double d2 = this.q + (this.U.nextFloat() - 0.5F) * 64.0F;
      return this.a_(d, d1, d2);
   }

   protected boolean d(Entity par1Entity) {
      bo vec3d = bo.b(this.o - par1Entity.o, this.y.b + this.J / 2.0F - par1Entity.p + par1Entity.I(), this.q - par1Entity.q);
      vec3d = vec3d.c();
      double d = 16.0;
      double d1 = this.o + (this.U.nextFloat() - 0.5F) * 8.0F - vec3d.a * d;
      double d2 = this.p + (this.U.nextInt(16) - 8) - vec3d.b * d;
      double d3 = this.q + (this.U.nextFloat() - 0.5F) * 8.0F - vec3d.c * d;
      return this.a_(d1, d2, d3);
   }

   protected boolean a_(double par1, double par3, double par5) {
      double d = this.o;
      double d1 = this.p;
      double d2 = this.q;
      this.o = par1;
      this.p = par3;
      this.q = par5;
      boolean flag = false;
      long i = MathHelper.d(this.o);
      int j = MathHelper.c(this.p);
      long k = MathHelper.d(this.q);
      if (this.k.blockExists(i, j, k)) {
         boolean flag1 = false;

         while (!flag1 && j > 0) {
            int i1 = this.k.getBlockId(i, j - 1, k);
            if (i1 != 0 && Block.m[i1].cd.c()) {
               flag1 = true;
            } else {
               this.p--;
               j--;
            }
         }

         if (flag1) {
            this.d(this.o, this.p, this.q);
            if (this.k.a(this, this.y).size() == 0 && !this.k.b(this.y)) {
               flag = true;
            }
         }
      }

      if (!flag) {
         this.d(d, d1, d2);
         return false;
      }

      int l = 128;

      for (int j1 = 0; j1 < l; j1++) {
         double d3 = j1 / (l - 1.0);
         float f = (this.U.nextFloat() - 0.5F) * 0.2F;
         float f1 = (this.U.nextFloat() - 0.5F) * 0.2F;
         float f2 = (this.U.nextFloat() - 0.5F) * 0.2F;
         double d4 = d + (this.o - d) * d3 + (this.U.nextFloat() - 0.5F) * this.I * 2.0F;
         double d5 = d1 + (this.p - d1) * d3 + this.U.nextFloat() * this.J;
         double d6 = d2 + (this.q - d2) * d3 + (this.U.nextFloat() - 0.5F) * this.I * 2.0F;
         this.k.a("portal", d4, d5, d6, f, f1, f2);
      }

      this.k.a(d, d1, d2, "mob.endermen.portal", 1.0F, 1.0F);
      this.k.a(this, "mob.endermen.portal", 1.0F, 1.0F);
      return true;
   }

   @Override
   protected String m() {
      return "mob.endermen.idle";
   }

   @Override
   protected String n() {
      return "mob.endermen.hit";
   }

   @Override
   protected String o() {
      return "mob.endermen.death";
   }

   @Override
   protected int f() {
      return Item.BiomeGenJungle.bQ;
   }

   @Override
   protected void a(boolean par1, int par2) {
      int i = this.f();
      if (i > 0) {
         int j = this.U.nextInt(2 + par2);

         for (int k = 0; k < j; k++) {
            this.b(i, 1);
         }
      }
   }

   public void g_(int par1) {
      this.EntityNoteFX.b(16, (byte)(par1 & 0xFF));
   }

   public int z_() {
      return this.EntityNoteFX.a(16);
   }

   public void h_(int par1) {
      this.EntityNoteFX.b(17, (byte)(par1 & 0xFF));
   }

   public int x() {
      return this.EntityNoteFX.a(17);
   }

   @Override
   public boolean a(md par1DamageSource, int par2) {
      if (par1DamageSource instanceof ft) {
         for (int i = 0; i < 64; i++) {
            if (this.u()) {
               return true;
            }
         }

         return false;
      } else {
         return super.a(par1DamageSource, par2);
      }
   }

   static {
      b[Block.u.bO] = true;
      b[Block.v.bO] = true;
      b[Block.E.bO] = true;
      b[Block.F.bO] = true;
      b[Block.ad.bO] = true;
      b[Block.BlockTNT.bO] = true;
      b[Block.TileEntityMobSpawnerRenderer.bO] = true;
      b[Block.ag.bO] = true;
      b[Block.NoiseGeneratorPerlin.bO] = true;
      b[Block.aV.bO] = true;
      b[Block.aW.bO] = true;
      b[Block.ba.bO] = true;
      b[Block.br.bO] = true;
      b[Block.by.bO] = true;
   }
}
