public class BiomeGenEnd extends BiomeGenBase {
   public BiomeGenEnd(int par1) {
      super(par1);
      this.J.clear();
      this.K.clear();
      this.J.add(new bg(EntityEnderman.class, 10, 4, 4));
      this.A = (byte)Block.v.bO;
      this.B = (byte)Block.v.bO;
      this.I = new BiomeEndDecorator(this);
   }

   @Override
   public int a(float par1) {
      return 0;
   }
}
