package emfer.examples.ferryman;

import emfer.examples.ferryman.Bank;
import emfer.examples.ferryman.River;
import emfer.reachability.ReachabilityGraph;
import emfer.reachability.ReachableState;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class FerryManReachabilityQuery {
  public ReachableState findFinal(final ReachabilityGraph g) {
    ReachableState _xblockexpression = null;
    {
      EList<ReachableState> states = g.getStates();
      final Function1<ReachableState, Boolean> _function = (ReachableState s) -> {
        return Boolean.valueOf(this.isFinal(s));
      };
      _xblockexpression = IterableExtensions.<ReachableState>findFirst(states, _function);
    }
    return _xblockexpression;
  }
  
  public boolean isFinal(final ReachableState state) {
    EObject _root = state.getRoot();
    final Function1<Bank, Boolean> _function = (Bank it) -> {
      return Boolean.valueOf(it.getName().equals("right"));
    };
    Bank rightBank = IterableExtensions.<Bank>findFirst(((River) _root).getBanks(), _function);
    int _size = rightBank.getCargos().size();
    return (_size == 3);
  }
}
