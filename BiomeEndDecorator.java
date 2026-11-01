public class BiomeEndDecorator extends BiomeDecorator {
   protected WorldGenerator L = new WorldGenSpikes(Block.bJ.bO);

   public BiomeEndDecorator(BiomeGenBase par1BiomeGenBase) {
      super(par1BiomeGenBase);
   }

   @Override
   protected void a() {
      this.b();
      if (this.b.nextInt(5) == 0) {
         long i = this.c + this.b.nextInt(16) + 8L;
         long j = this.d + this.b.nextInt(16) + 8L;
         int k = this.a.getTopSolidOrLiquidBlock(i, j);
         if (k <= 0) {
         }

         this.L.generate(this.a, this.b, i, k, j);
      }

      if (this.c == 0L && this.d == 0L) {
         EntityDragon entitydragon = new EntityDragon(this.a);
         entitydragon.c(0.0, 128.0, 0.0, this.b.nextFloat() * 360.0F, 0.0F);
         this.a.a(entitydragon);
      }
   }
}
