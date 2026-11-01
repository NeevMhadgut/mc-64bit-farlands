import java.util.List;

public class EntityLightningBolt extends si {
   private int b;
   public long a = 0L;
   private int c;

   public EntityLightningBolt (World par1World, double par2, double par4, double par6) {
      super(par1World);
      this.c(par2, par4, par6, 0.0F, 0.0F);
      this.b = 2;
      this.a = this.U.nextLong();
      this.c = this.U.nextInt(3) + 1;
      if (par1World.q >= 2 && par1World.doChunksNearChunkExist(MathHelper.EntityLightningBolt (par2), MathHelper.c(par4), MathHelper.EntityLightningBolt (par6), 10)) {
         long i = MathHelper.EntityLightningBolt (par2);
         int k = MathHelper.c(par4);
         long i1 = MathHelper.EntityLightningBolt (par6);
         if (par1World.getBlockId(i, k, i1) == 0 && Block.ar.canPlaceBlockAt(par1World, i, k, i1)) {
            par1World.setBlockWithNotify(i, k, i1, Block.ar.bO);
         }

         for (int j = 0; j < 4; j++) {
            long l = MathHelper.EntityLightningBolt (par2) + this.U.nextInt(3) - 1L;
            int j1 = MathHelper.c(par4) + this.U.nextInt(3) - 1;
            long k1 = MathHelper.EntityLightningBolt (par6) + this.U.nextInt(3) - 1L;
            if (par1World.getBlockId(l, j1, k1) == 0 && Block.ar.canPlaceBlockAt(par1World, l, j1, k1)) {
               par1World.setBlockWithNotify(l, j1, k1, Block.ar.bO);
            }
         }
      }
   }

   public void J_() {
      super.J_();
      if (this.b == 2) {
         this.k.a(this.o, this.p, this.q, "ambient.weather.thunder", 10000.0F, 0.8F + this.U.nextFloat() * 0.2F);
         this.k.a(this.o, this.p, this.q, "random.explode", 2.0F, 0.5F + this.U.nextFloat() * 0.2F);
      }

      this.b--;
      if (this.b < 0) {
         if (this.c == 0) {
            this.A();
         } else if (this.b < -this.U.nextInt(10)) {
            this.c--;
            this.b = 1;
            this.a = this.U.nextLong();
            if (this.k.doChunksNearChunkExist(MathHelper.EntityLightningBolt (this.o), MathHelper.c(this.p), MathHelper.EntityLightningBolt (this.q), 10)) {
               long i = MathHelper.EntityLightningBolt (this.o);
               int j = MathHelper.c(this.p);
               long k = MathHelper.EntityLightningBolt (this.q);
               if (this.k.getBlockId(i, j, k) == 0 && Block.ar.canPlaceBlockAt(this.k, i, j, k)) {
                  this.k.setBlockWithNotify(i, j, k, Block.ar.bO);
               }
            }
         }
      }

      if (this.b >= 0) {
         double d = 3.0;
         List list = this.k.b(this, AxisAlignedBB.b(this.o - d, this.p - d, this.q - d, this.o + d, this.p + 6.0 + d, this.q + d));

         for (int l = 0; l < list.size(); l++) {
            Entity entity = (Entity)list.get(l);
            entity.a(this);
         }

         this.k.n = 2;
      }
   }

   protected void b() {
   }

   protected void a(ady nbttagcompound) {
   }

   protected void b(ady nbttagcompound) {
   }

   public boolean a(bo par1Vec3D) {
      return this.b >= 0;
   }
}
