public class BiomeGenHell extends BiomeGenBase {
   public BiomeGenHell(int par1) {
      super(par1);
      this.J.clear();
      this.K.clear();
      this.J.add(new bg(EntityGhast.class, 50, 4, 4));
      this.J.add(new bg(alt.class, 100, 4, 4));
      this.J.add(new bg(aic.class, 1, 4, 4));
   }
}
